<template>
    <div>
        <form class="md-layout">
            <md-card>
                <md-card-header>
                    <div class="md-title">New Party</div>
                </md-card-header>

                <md-card-content>
                    <md-field>
                        <label>Party Name</label>
                        <md-input name="party-name" id="party-name" v-model="form.partyName"/>
                        <span class="md-error">The party name is required</span>
                        <span class="md-error">Invalid party name</span>
                    </md-field>

                    <md-card-actions>
                        <md-button class="md-primary" v-on:click="submitNewParty">Create Party</md-button>
                    </md-card-actions>
                </md-card-content>
            </md-card>
        </form>
    </div>
</template>

<script>
    import {PartyService} from "@/api";
    import {required, minLength} from 'vuelidate/lib/validators'

    export default {
        name: "PartyAdd",
        validations: {
            form: {
                partyName: {
                    required,
                    minLength: minLength(3)
                }
            }
        },
        data: () => ({
            form: {
                partyName: null
            }
        }),
        methods: {
            async submitNewParty() {
                PartyService.create({
                    name: this.form.partyName
                }).then(response => {
                    this.$emit('submit', {
                            id: response.data,
                            name: this.form.partyName
                        }
                    );
                    this.form.partyName = '';
                });
            }
        }
    }
</script>

<style scoped>

</style>