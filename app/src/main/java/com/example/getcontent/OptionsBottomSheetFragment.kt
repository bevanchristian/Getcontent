package com.sample
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.getcontent.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.sample.R
import kotlinx.android.synthetic.main.bottom_sheet_options.*
import kotlinx.android.synthetic.main.bottom_sheet_share.*
import java.lang.ref.WeakReference

//ini kok pada error gatau kenapa

class OptionsBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        // We can have cross button on the top right corner for providing elemnet to dismiss the bottom sheet
        //iv_close.setOnClickListener { dismissAllowingStateLoss() }
        txt_download.setOnClickListener {
            dismissAllowingStateLoss()
            Toast.makeText(application, "Download option clicked", Toast.LENGTH_LONG)
                .show()
        }

        txt_share.setOnClickListener {
            dismissAllowingStateLoss()
            Toast.makeText(application, "Share option clicked", Toast.LENGTH_LONG)
                .show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle): OptionsBottomSheetFragment {
            val fragment = OptionsBottomSheetFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}