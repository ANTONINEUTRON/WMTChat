package com.tech4dev.wmtchat.fragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tech4dev.wmtchat.R
import java.lang.Exception

class CameraFragment : Fragment() {
    private lateinit var cameraPreview: PreviewView
    private lateinit var takePhotoBtn: FloatingActionButton
    private lateinit var imageCaptured: ImageCapture

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cameraPreview = view.findViewById(R.id.cameraPreview)
        takePhotoBtn = view.findViewById(R.id.takePhotoBtn)

        if(allPermissionsGranted()){
            //start camera
            startCamera()
        }else{
            //request permission
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.CAMERA),
                111
            )
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({
            //bind to lifecycle
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build()
            preview.setSurfaceProvider(cameraPreview.surfaceProvider)
            imageCaptured = ImageCapture.Builder().build()

            //select the camera to use
            val cameraSelected = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraProvider.unbindAll()

                cameraProvider.bindToLifecycle(
                    this,
                    cameraSelected,
                    preview,
                    imageCaptured
                )
            } catch (e: Exception) {
                Log.e("WMTchat", "Camera Binding Failed $e")

                Toast.makeText(requireContext(), "Camera Binding unsucceccful", Toast.LENGTH_LONG)
                    .show()
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }

    private fun allPermissionsGranted(): Boolean {
        return ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

}