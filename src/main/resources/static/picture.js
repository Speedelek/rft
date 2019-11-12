function f(arg) {
    if(arg=1){
        picture('cocolate',6);
    }
    else if(arg=2){
        picture('drink',7);
    }
    else if(arg=3){
        picture('fryUp',7);
    }
    else if(arg=4){
        picture('gyros',6);
    }
    else if(arg=5){
        picture('hamburger',6);
    }
    else if(arg=6){
        picture('sandwich',7);
    }
    else if(arg=7){
        picture('snack',9);
    }
};
function picture(arg,max) {
    var src="",
        dir = '../../static/images/' + arg,         //images folder
        num = 1,                                      //start number
        len = max;                                      //limit
    setInterval(function(){                           //interval changer
        src = dir + num+'.jpg';                       //change picture
        num = (num === len) ? 0 : ++num;              //reset if last image reached
    });
}

