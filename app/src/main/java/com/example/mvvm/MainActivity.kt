package      com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //como instanciar o mvvm
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //padrão para chamar a var criada lá em MainViewModel - como o Leo Faz
        /*viewModel.textWelcome.observe(this) {

        }*/

        viewModel.textWelcome.observe(this, Observer {
            binding.textWelcome.text = it
        })

       /* binding.buttonLogin.setOnClickListener {
            viewModel.login1()
        }*/

        binding.buttonLogin.setOnClickListener {
            val login = binding.editName.text.toString()
            viewModel.login(login)
        }

        viewModel.login.observe(this, Observer {
            if (it) {
                Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Falha", Toast.LENGTH_SHORT).show()
            }
        })

    }
}