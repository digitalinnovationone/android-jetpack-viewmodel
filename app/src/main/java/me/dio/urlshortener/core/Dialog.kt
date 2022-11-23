package me.dio.urlshortener.core

import android.content.Context
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import me.dio.urlshortener.R

fun Context.createDialog(block: MaterialAlertDialogBuilder.() -> Unit = {}): AlertDialog =
    MaterialAlertDialogBuilder(this)
        .apply {
            setPositiveButton(android.R.string.ok, null)
            block()
        }
        .create()

fun Context.createProgressDialog(title: String): AlertDialog = createDialog {
    val padding = resources.getDimensionPixelOffset(R.dimen.spacing_2x)
    val progressBar = ProgressBar(this@createProgressDialog).apply {
        setPadding(padding, padding, padding, padding)
    }
    setTitle(title)
    setView(progressBar)

    setPositiveButton(null, null)
    setCancelable(false)
}