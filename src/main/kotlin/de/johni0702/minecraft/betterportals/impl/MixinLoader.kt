package de.johni0702.minecraft.betterportals.impl

import com.google.common.collect.ImmutableList
import net.minecraft.launchwrapper.Launch
import net.minecraftforge.fml.relauncher.CoreModManager
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin
import org.apache.logging.log4j.LogManager
import org.spongepowered.asm.launch.MixinBootstrap
import org.spongepowered.asm.mixin.Mixins
import zone.rong.mixinbooter.IEarlyMixinLoader
import java.io.File
import java.net.URISyntaxException

open class MixinLoader(val root: File) : IFMLLoadingPlugin, IEarlyMixinLoader {
    @Suppress("unused")
    constructor() : this(File(".."))

    init {

    }

    override fun getASMTransformerClass(): Array<String> = arrayOf()

    override fun getModContainerClass(): String? = null

    override fun getSetupClass(): String? = null

    override fun injectData(data: Map<String, Any>) {}

    override fun getAccessTransformerClass(): String? = null
    override fun getMixinConfigs(): MutableList<String> {
        return ImmutableList.of("mixins.betterportals.json", "mixins.betterportals.view.json", "mixins.betterportals.transition.json")
    }
}
