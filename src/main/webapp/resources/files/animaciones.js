var theForm = document.forms['master'];
if (!theForm) {
    theForm = document.master;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}

$(document).ready(function ($) {
  /*  
    $('.ZTmenu_drop').hoverIntent({
        sensitivity: 3, // number = sensitivity threshold (must be 1 or higher)
        interval: 200, // number = milliseconds for onMouseOver polling interval
        timeout: 600, // number = milliseconds delay before onMouseOut
        over: function () {
            $(this).find('dropdown_fullwidth dropdown_first').addClass('mostrar');
        },
        out: function () {
            $(this).find("dropdown_fullwidth dropdown_first").removeClass('mostrar');
        }
    
    })
    
*/
    $('.CatalogContent').each(function (index) {
        if (index == 0) {
            $(this).show();
        }
        $(this).attr("id", "CatalogContent" + index);
    });
    
    $('.mgmenu_tabs_nav li a').each(function (index) {
        if (index == 0) {
            $(this).addClass('current');
        }
        $(this).attr("href", "#CatalogContent" + index);
    });
    
    $('.ZTmenu_vertical li').hoverIntent({
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
    setTimeout('CategoryMenuVertical();', 1000);
});

$(".imgPhoto").click(function () {
    if ($(this).attr("data-href") != null) {
        document.location.href = $(this).attr("data-href");
    }
});

$(window).load(function () {
    $('.flexslider').flexslider({
        animation: "slide",
        start: function (slider)
        {
            slider.removeClass('loading');
        }

    });
});

ReLoadScriptUpdatePanel(SetViewStyle);

Sys.WebForms.PageRequestManager._initialize('ctl00$ScriptManager1', 'master', ['tctl00$BasketOnTopUserControl$ModalUpdatePanel', 'ModalUpdatePanel', 'tctl00$MainContent$ProductListUserControl$upnlProductListAux', 'MainContent_ProductListUserControl_upnlProductListAux', 'tctl00$MainContent$VerticalBannerUserControl$upnlProductList', 'MainContent_VerticalBannerUserControl_upnlProductList', 'tctl00$MainContent$ProductListUserControl3$upnlProductListAux', 'MainContent_ProductListUserControl3_upnlProductListAux', 'tctl00$updSub', 'updSub'], [], [], 90, 'ctl00');


