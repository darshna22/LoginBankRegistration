package com.darshna.login.utility

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Utils of this application use static methods of application.
 *
 * @author Darshna/2148
 */
object AndroidAppUtils {
  private val TAG = "AndroidAppUtils"
  private const val DATE_PATTERN =
      "^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\d\\d$"

    /**
   * check network Connection Available if not then its return
   * true/false value and show network connectivity dialog
   *
   * @param activity activity instance
   * @return true/false
   */
  @RequiresApi(api = Build.VERSION_CODES.KITKAT)
  fun isNetworkConnectionAvailable(activity: Activity?): Boolean {
    val cm = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = Objects.requireNonNull(cm).activeNetworkInfo
    val isConnected = activeNetwork != null && activeNetwork.isConnected
    return isConnected
  }

  fun showToastMsg(activity: Activity?, msg: String) {
    Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
  }

  // Function to validate the PAN Card number.
  fun isValidPanCardNo(
    panCardNo: String?
  ): Boolean { // Regex to check valid PAN Card number.
    val regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}"
    // Compile the ReGex
    val p: Pattern = Pattern.compile(regex)
    // If the PAN Card number
// is empty return false
    if (panCardNo == null) {
      return false
    }
    // Pattern class contains matcher() method
// to find matching between given
// PAN Card number using regular expression.
    val m: Matcher = p.matcher(panCardNo)
    // Return if the PAN Card number
// matched the ReGex
    return m.matches()
  }

  /**
   * Validate date format with regular expression
   * @param date date address for validation
   * @return true valid date format, false invalid date format
   */
  fun validateDate(date: String): Boolean {
    // Compile the ReGex
    val pattern: Pattern = Pattern.compile(DATE_PATTERN)
    val matcher: Matcher = pattern.matcher(date)
    return matcher.matches()

  }

}