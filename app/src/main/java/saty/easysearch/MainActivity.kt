package saty.easysearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.what3words.javawrapper.response.SuggestionWithCoordinates
import saty.easysearch.databinding.ActivityMainBinding
import saty.threewords.ThreeWordView
import saty.threewords.WhatThreeWordsResult

class MainActivity : AppCompatActivity(), ThreeWordView.OnWhat3WordResultListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val customView: ThreeWordView = binding.customView
        customView.setOnWhat3WordResultListener(this)
        setContentView(binding.root)
    }

    override fun onWhat3WordResult(result: WhatThreeWordsResult) {
        val data: SuggestionWithCoordinates = result.suggestionWithCoordinates
        if (data.coordinates == null) binding.resultText.text = "No coordinates for: ${data.words}"
        else binding.resultText.text =
            "Result->\n" +
                    "${data.words}\n" +
                    "Lat:${data.coordinates.lat}\n" +
                    "Lng:${data.coordinates.lng}"
    }
}