package com.apoorvgupta.draftjscompose.data

import com.apoorvgupta.draftjscompose.utils.DraftJsUtils.emptyValue
import com.google.gson.annotations.SerializedName

data class DraftJS(
    val blocks: List<Block>,
    val entityMap: Map<String, Entity>,
) {
    companion object {
        val emptyValue: DraftJS
            get() = DraftJS(
                blocks = emptyList(),
                entityMap = emptyMap(),
            )
    }
}

data class Block(
    val key: String,
    val text: String,
    val type: String,
    val depth: Int,
    val inlineStyleRanges: List<StyleRange>,
    val entityRanges: List<EntityRange>,
    val data: BlockData,
) {
    companion object {
        val emptyValue: Block
            get() = Block(
                key = String.emptyValue(),
                text = String.emptyValue(),
                type = String.emptyValue(),
                depth = Int.emptyValue(),
                inlineStyleRanges = emptyList(),
                entityRanges = emptyList(),
                data = BlockData.emptyValue,
            )
    }
}

data class StyleRange(
    val offset: Int,
    val length: Int,
    val style: String,
) {
    companion object {
        val emptyValue: StyleRange
            get() = StyleRange(
                offset = Int.emptyValue(),
                length = Int.emptyValue(),
                style = String.emptyValue(),
            )
    }
}

data class EntityRange(
    val offset: Int,
    val length: Int,
    val key: Int,
) {
    companion object {
        val emptyValue: EntityRange
            get() = EntityRange(
                offset = Int.emptyValue(),
                length = Int.emptyValue(),
                key = Int.emptyValue(),
            )
    }
}

data class Entity(
    val type: String,
    val mutability: String,
    val data: EntityData,
) {
    companion object {
        val emptyValue: Entity
            get() = Entity(
                type = String.emptyValue(),
                mutability = String.emptyValue(),
                data = EntityData.emptyValue,
            )
    }
}

data class EntityData(
    val url: String,
    val targetOption: String,
) {
    companion object {
        val emptyValue: EntityData
            get() = EntityData(
                url = String.emptyValue(),
                targetOption = String.emptyValue(),
            )
    }
}

data class BlockData(
    @SerializedName("text-align")
    val textAlign: String,
) {
    companion object {
        val emptyValue: BlockData
            get() = BlockData(
                textAlign = String.emptyValue(),
            )
    }
}
