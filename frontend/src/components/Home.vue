<template>
    <div>
        <nav>
            <router-link :to="{name: 'party-overview'}">To Party list</router-link>
            <p></p>
            <router-link :to="{name: 'character-overview'}">To Character list</router-link>
        </nav>
    </div>
</template>

<script>
    export default {
        name: "Home"
    }
</script>

<style scoped>

</style>