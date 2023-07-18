package com.example.languagedetector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.languagedetector.databinding.ActivityMainBinding
import com.google.mlkit.nl.languageid.LanguageIdentification

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val languageIdentifier = LanguageIdentification.getClient()

        binding.button.setOnClickListener {
            languageIdentifier.identifyLanguage(binding.editText.text.toString())
                .addOnSuccessListener { languageCode ->
                    if (languageCode == "und") {
                        binding.textView.text = "Can't detect language"
                    } else {
                        binding.textView.text = languageCode
                    }
                }
        }
    }
}