package com.thk.plugin

open class HappyXPluginExtension {

    /**
     * configure BuildConfig generation
     */
    open var buildConfigGeneration = false

    /**
     * apply "kotlin-parcelize" plugin
     */
    open var kotlinParcelize = false

    /**
     * configure ViewBinding
     */
    open var viewBinding = false
}