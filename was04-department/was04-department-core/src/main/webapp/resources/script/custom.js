/////////////////* NAVIGATION */////////////////////////
if ((screen.width >= 1024) && (screen.height >= 768)) {
    $(window).load(function () {
        $('#navigation a').stop().animate({ 'marginTop': '0px' }, 1000);

        $('#navigation > li').hover(
                    function () {
                        $('a', $(this)).stop().animate({ 'marginTop': '100px' }, 200);
                    },
                    function () {
                        $('a', $(this)).stop().animate({ 'marginTop': '0px' }, 200);
                    }
                );
    });
}
else {
    $(window).load(function () {
        $('#navigation a').stop().animate({ 'marginTop': '0px' }, 1000);
    });
}

