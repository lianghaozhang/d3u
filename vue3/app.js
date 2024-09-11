const app = Vue.createApp({
    data() {
        return {
            name: 'aniu',
            age: 20,
            date: '2004-09-02',
            show: true,
            x: 0,
            y: 0,
            students: [
                {name: 'jack', age: 20, isFav: true},
                {name: 'tom', age: 21, isFav: false},
                {name: 'lucy', age: 19, isFav: true}
            ]
        }
    },
    methods: {
        showName(){
            this.show = !this.show;
        },
        handleEvent(e){
            console.log(e);
            console.log(e.type);
            
        },
        mmHandle(e){
            console.log(e);
            
            this.x = e.offsetX;
            this.y = e.offsetY;
        },
        changeColor(index){
            this.students[index].isFav = !this.students[index].isFav;
        }
    }
})

app.mount('#abc')