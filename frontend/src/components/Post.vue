<template>
    <div>
        <String label="게시물이름" v-model="value.postName" :editMode="editMode"/>
        <PostId offline label="postId" v-model="value.postId" :editMode="editMode" @change="change"/>
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Post',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "posts",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
