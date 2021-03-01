package com.darshna.login.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.darshna.login.R
import com.darshna.login.databinding.FragmentLoginBinding
import com.darshna.login.di.MyApplication
import com.darshna.login.utility.AndroidAppUtils
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class RegistrationLoginFragment : Fragment() {
  // @Inject annotated fields will be provided by Dagger
  @Inject lateinit var vm: RegistrationLoginViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    val binding: FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)
    val view = binding.root
    binding.vm = this.vm
    return view
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    // Ask Dagger to inject our dependencies
    (context.applicationContext as MyApplication).appComponent.inject(this)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    no_pan_number.setOnClickListener {
      activity?.finish()
    }

    vm.msg.observe(viewLifecycleOwner, Observer {
      prgrs_main.visibility = View.GONE
      AndroidAppUtils.showToastMsg(activity, getString(R.string.success_msg))
      activity?.finish()
    })


    nextBtn.setOnClickListener {
      if (isFilled()) {
        if (AndroidAppUtils.isValidPanCardNo(panNumberEdit.text.toString())) {
          if (!AndroidAppUtils.validateDate(day.text.toString() + "/" + month.text.toString() + "/" + year.text.toString()))
            AndroidAppUtils.showToastMsg(activity, getString(R.string.valid_dob))
          else {
            prgrs_main.visibility = View.VISIBLE
            vm.initialize(panNumberEdit.text.toString())
          }
        } else
          AndroidAppUtils.showToastMsg(activity, getString(R.string.valid_pan))
      } else
        AndroidAppUtils.showToastMsg(activity, getString(R.string.fill_detail))

    }

  }

  private fun isFilled(): Boolean {
    var boolean = true
    when {
      panNumberEdit.text.isEmpty() -> boolean = false
      day.text.isEmpty() -> boolean = false
      month.text.isEmpty() -> boolean = false
      year.text.isEmpty() -> boolean = false
    }

    return boolean
  }

  companion object {
    @JvmStatic
    fun newInstance(): RegistrationLoginFragment {
      return RegistrationLoginFragment()
    }
  }
}