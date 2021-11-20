package com.rujirakongsomran.kt_scanwithmlkit

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.mlkit.vision.barcode.Barcode
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configure the barcode scanner
        val options = BarcodeScannerOptions.Builder()
            .setBarcodeFormats(
                Barcode.FORMAT_QR_CODE
            )
            .build()

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.qrcode)
        // Using a Bitmap
        val image = InputImage.fromBitmap(bitmap, 0)

        // Get an instance of BarcodeScanner
        val scanner = BarcodeScanning.getClient(options)

        // Process the image
        val result = scanner.process(image)
            .addOnSuccessListener { barcodes ->
                // Task completed successfully
                // ...
            }
            .addOnFailureListener {
                // Task failed with an exception
                // ...
            }
    }
}