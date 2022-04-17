package com.example.returnkotlin.viewmodel


import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Environment
import com.example.returnkotlin.base.BaseViewModel
import com.example.returnkotlin.ui.SelectOperationFragmentDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class SelectOperationViewModel @Inject constructor() : BaseViewModel() {

    fun onCountryListClick() {
        navigate(SelectOperationFragmentDirections.actionToCountryList())
    }

    fun onPublicHolidayClick() {
        navigate(SelectOperationFragmentDirections.actionHolidayFragment())
    }

    fun onCountryInfoClick() {
        navigate(SelectOperationFragmentDirections.actionToCountryInfoFragment())
    }

    fun onCreatePDFClick() {

        val pdfDocument = PdfDocument()
        val paint = Paint()

        val pageInfo = PdfDocument.PageInfo.Builder(3508,2480,1).create()
        val page = pdfDocument.startPage(pageInfo)

        val canvas = page.canvas
        canvas.drawText("DENEME",1F, 1F,paint)
        pdfDocument.finishPage(page)

        val file = File(Environment.getExternalStorageDirectory(),"/First.pdf")

        try {
            pdfDocument.writeTo(FileOutputStream(file))
        } catch (e : IOException){

        }


    }

}