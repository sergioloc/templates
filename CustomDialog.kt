import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class CustomDialog constructor(val context: Context) {

    private var dialog: Dialog = Dialog(context)
    private var btnOk: Button? = null

    init {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_custom)
        dialog.setCanceledOnTouchOutside(false)
        dialog.window?.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        btnOk = dialog.findViewById(R.id.btn_yes) as Button
        val btnCancel = dialog.findViewById(R.id.btn_no) as Button
        btnCancel.setOnClickListener { dialog.dismiss() }
    }

    fun setTitle(title: String){
        val tvTitle = dialog.findViewById(R.id.tv_title) as TextView
        tvTitle.text = title
    }

    fun setOnClickListener(onClickListener: () -> Unit) {
        btnOk?.setOnClickListener {
            onClickListener()
        }
    }

    fun show(){
        dialog.show()
    }

}