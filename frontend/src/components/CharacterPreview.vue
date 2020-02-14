<template>
    <div>
        <p>id = {{id}} || name = {{name}}</p>
    </div>
</template>

<script>
    export default {
        name: "CharacterPreview",
        props: {
            id: Number,
            name: String
        }
    }
</script>

<style scoped>

</style>