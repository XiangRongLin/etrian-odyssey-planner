<template>
    <div>
        <span>as</span>
        <p>{{id}}</p>
        <h3>{{name}}</h3>
    </div>
</template>

<script>
    export default {
        name: "Party",
        props: {
            id: Number,
            name: String
        },
    }
</script>

<style scoped>

</style>