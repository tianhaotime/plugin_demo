package com.example.myapplication

import android.content.res.*
import android.content.res.loader.ResourcesLoader
import android.graphics.Movie
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import androidx.annotation.RequiresApi
import java.io.InputStream

class PluginResources(val hostResources: Resources, val injectResources: Resources) : Resources(
    injectResources.assets,
    injectResources.displayMetrics,
    injectResources.configuration
) {

    override fun getText(id: Int): CharSequence {
        try {
            return injectResources.getText(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getText(id)
    }

    override fun getText(id: Int, def: CharSequence?): CharSequence {
        try {
            return injectResources.getText(id, def)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getText(id, def)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getFont(id: Int): Typeface {
        try {
            return injectResources.getFont(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getFont(id)
    }

    override fun getQuantityText(id: Int, quantity: Int): CharSequence {

        try {
            return injectResources.getQuantityText(id, quantity)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getQuantityText(id, quantity)
    }

    override fun getString(id: Int): String {

        try {
            return injectResources.getString(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getString(id)
    }

    override fun getString(id: Int, vararg formatArgs: Any?): String {
        try {
            return injectResources.getString(id, *formatArgs)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getString(id, *formatArgs)
    }

    override fun getQuantityString(id: Int, quantity: Int, vararg formatArgs: Any?): String {

        try {
            return injectResources.getQuantityString(id, quantity, *formatArgs)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getQuantityString(id, quantity, *formatArgs)
    }

    override fun getQuantityString(id: Int, quantity: Int): String {
        try {
            return injectResources.getQuantityString(id, quantity)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getQuantityString(id, quantity)
    }

    override fun getTextArray(id: Int): Array<CharSequence> {
        try {
            return injectResources.getTextArray(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getTextArray(id)
    }

    override fun getStringArray(id: Int): Array<String> {

        try {
            return injectResources.getStringArray(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getStringArray(id)
    }

    override fun getIntArray(id: Int): IntArray {
        try {
            return injectResources.getIntArray(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getIntArray(id)
    }

    override fun obtainTypedArray(id: Int): TypedArray {
        try {
            return injectResources.obtainTypedArray(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.obtainTypedArray(id)
    }

    override fun getDimension(id: Int): Float {
        try {
            return injectResources.getDimension(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getDimension(id)
    }

    override fun getDimensionPixelOffset(id: Int): Int {
        try {
            return injectResources.getDimensionPixelOffset(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getDimensionPixelOffset(id)
    }

    override fun getDimensionPixelSize(id: Int): Int {
        try {
            return injectResources.getDimensionPixelSize(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getDimensionPixelSize(id)
    }

    override fun getFraction(id: Int, base: Int, pbase: Int): Float {

        try {
            return injectResources.getFraction(id, base, pbase)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getFraction(id, base, pbase)
    }

    override fun getDrawable(id: Int): Drawable {

        try {
            return injectResources.getDrawable(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getDrawable(id)
    }

    override fun getDrawable(id: Int, theme: Theme?): Drawable {

        try {
            return injectResources.getDrawable(id, theme)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getDrawable(id, theme)
    }

    override fun getDrawableForDensity(id: Int, density: Int): Drawable? {

        try {
            return injectResources.getDrawableForDensity(id, density)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getDrawableForDensity(id, density)
    }

    override fun getDrawableForDensity(id: Int, density: Int, theme: Theme?): Drawable? {
        try {
            return injectResources.getDrawableForDensity(id, density, theme)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getDrawableForDensity(id, density, theme)
    }

    override fun getMovie(id: Int): Movie {

        try {
            return injectResources.getMovie(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getMovie(id)
    }

    override fun getColor(id: Int): Int {

        try {
            return injectResources.getColor(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getColor(id)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun getColor(id: Int, theme: Theme?): Int {

        try {
            return injectResources.getColor(id, theme)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getColor(id, theme)
    }

    override fun getColorStateList(id: Int): ColorStateList {

        try {
            return injectResources.getColorStateList(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getColorStateList(id)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun getColorStateList(id: Int, theme: Theme?): ColorStateList {

        try {
            return injectResources.getColorStateList(id, theme)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getColorStateList(id, theme)
    }

    override fun getBoolean(id: Int): Boolean {
        try {
            return injectResources.getBoolean(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getBoolean(id)
    }

    override fun getInteger(id: Int): Int {

        try {
            return injectResources.getInteger(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getInteger(id)
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun getFloat(id: Int): Float {

        try {
            return injectResources.getFloat(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getFloat(id)
    }

    override fun getLayout(id: Int): XmlResourceParser {
        try {
            return injectResources.getLayout(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getLayout(id)
    }

    override fun getAnimation(id: Int): XmlResourceParser {
        try {
            return injectResources.getAnimation(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getAnimation(id)
    }

    override fun getXml(id: Int): XmlResourceParser {
        try {
            return injectResources.getXml(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getXml(id)
    }

    override fun openRawResource(id: Int): InputStream {
        try {
            return injectResources.openRawResource(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.openRawResource(id)
    }

    override fun openRawResource(id: Int, value: TypedValue?): InputStream {
        try {
            return injectResources.openRawResource(id, value)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.openRawResource(id, value)
    }

    override fun openRawResourceFd(id: Int): AssetFileDescriptor {

        try {
            return injectResources.openRawResourceFd(id)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.openRawResourceFd(id)
    }

    override fun getValue(id: Int, outValue: TypedValue?, resolveRefs: Boolean) {


        try {
            return injectResources.getValue(id, outValue, resolveRefs)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getValue(id, outValue, resolveRefs)
    }

    override fun getValue(name: String?, outValue: TypedValue?, resolveRefs: Boolean) {


        try {
            return injectResources.getValue(name, outValue, resolveRefs)
        } catch (e: java.lang.Exception) {

        }
        return hostResources.getValue(name, outValue, resolveRefs)
    }


}