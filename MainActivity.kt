import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generateButton: Button = findViewById(R.id.generateButton)
        val passwordLengthInput: EditText = findViewById(R.id.passwordLengthInput)
        val passwordResult: TextView = findViewById(R.id.passwordResult)

        generateButton.setOnClickListener {
            val length = passwordLengthInput.text.toString().toIntOrNull() ?: 12
            val generatedPassword = generateRandomPassword(length)
            passwordResult.text = generatedPassword
        }
    }

    private fun generateRandomPassword(length: Int): String {
        val charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+"
        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }
}
