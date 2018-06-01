
$(document).ready(function ($) {
    $('.ZTmenu_drop').hoverIntent({
        sensitivity: 3, // number = sensitivity threshold (must be 1 or higher)
        interval: 200, // number = milliseconds for onMouseOver polling interval
        timeout: 600, // number = milliseconds delay before onMouseOut
        over: function () {
            $(this).find('.dropdown_fullwidth').fadeIn('fast');
        },
        out: function () {
            $(this).find(".dropdown_fullwidth").fadeOut('fast');
        }
    
    })
})

    