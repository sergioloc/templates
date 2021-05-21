import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Component @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr) {

    private val tvExample: TextView
    private val ivExample: ImageView
    private val button: Button

    init {
        View.inflate(this.context, R.layout.component, this) as ConstraintLayout

        tvExample = findViewById(R.id.tvExample)
        ivExample = findViewById(R.id.ivExample)
        button = findViewById(R.id.button)

        attributeSet?.let {
            val typedArray = getTypedArray(it)
            val text = typedArray.getString(R.styleable.Component_text)
            val image = typedArray.getDrawable(R.styleable.Component_image)

            tvExample.text = text
            ivExample.setImageDrawable(image)
        }
    }

    private fun getTypedArray(attributeSet: AttributeSet): TypedArray {
        return context.obtainStyledAttributes(attributeSet, R.styleable.Component,0,0)
    }

    fun setTextView(text: String) {
        tvExample.text = text
    }

    fun setOnClickListener(onClickListener: () -> Unit) {
        button.setOnClickListener {
            onClickListener()
        }
    }

}