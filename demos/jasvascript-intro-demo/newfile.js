var pi = 3.14159;
function myFunc() {
    console.log("myFunc");
}
var MyClass = /** @class */ (function () {
    function MyClass() {
        this.num = 5;
    }
    MyClass.prototype._memberFunc = function () {
        console.log("memberFunc");
    };
    return MyClass;
}());
