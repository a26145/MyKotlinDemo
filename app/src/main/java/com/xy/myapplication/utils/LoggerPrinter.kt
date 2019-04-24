package com.xy.myapplication.utils

object LoggerPrinter {

    private val MIN_STACK_OFFSET = 3

    /**
     * Drawing toolbox
     */
    private val TOP_LEFT_CORNER = '╔'
    private val BOTTOM_LEFT_CORNER = '╚'
    private val MIDDLE_CORNER = '╟'
    private val HORIZONTAL_DOUBLE_LINE = '║'
    private val DOUBLE_DIVIDER = "════════════════════════════════════════════"
    private val SINGLE_DIVIDER = "────────────────────────────────────────────"
    val TOP_BORDER = TOP_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER
    val BOTTOM_BORDER = BOTTOM_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER
    val MIDDLE_BORDER = MIDDLE_CORNER + SINGLE_DIVIDER + SINGLE_DIVIDER

    /**
     * It is used for json pretty print
     */
    val JSON_INDENT = 2

    fun getStackOffset(trace: Array<StackTraceElement>): Int {
        var i = MIN_STACK_OFFSET
        while (i < trace.size) {
            val e = trace[i]
            val name = e.className
            if (name != LoggerPrinter::class.java.name && name != L::class.java.name) {
                return --i
            }
            i++
        }
        return -1
    }
}

/**
 * Created by Tony Shen on 2016/12/28.
 */

//class MainActivity : Activity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)
//
//        L.init(this.javaClass)
//
//        initViews()
//        initData()
//    }
//
//    fun initViews():Unit{
//        val button = find<Button>(R.id.button)
//        button.setOnClickListener({ view ->
//
//            var intent =  Intent(this,SecondActivity::class.java)
//            startActivity(intent)
//        })
//    }
//
//    fun initData():Unit{
//
//        var s = "{\"firstName\":\"Brett\",\"lastName\":\"McLaughlin\",\"email\":\"aaaa\"}"
//        L.json(s)
//    }
//}


//public class SecondActivity extends Activity {
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        L.init(this.getClass());
//        L.i("this is second activity");
//    }
//}

