jQuery(function($) {
  var $win = $(window);

  var $gnavTrigger = $('#js-global-nav-trigger'),
      gnavTriggerClass = 'is-open',
      gnavOpenClass = 'gnav-open';
  $gnavTrigger.on('click', function(e) {
    $(this).toggleClass(gnavTriggerClass);
    $('body').toggleClass(gnavOpenClass);
    e.preventDefault();
  });

  var $gnavChildTrigger = $('.js-gnav-child-trigger'),
      gnavChildOpenClass = 'is-open';
  $gnavChildTrigger.on('click', function(e) {
    $(this).toggleClass(gnavChildOpenClass);
    $(this).stop().parent().next('.js-gnav-child-contents').slideToggle(400);
    e.preventDefault();
  });

  var $fnavChildTrigger = $('.js-global-footer-nav-child-trigger'),
      fnavChildOpenClass = 'is-open';
  $fnavChildTrigger.on('click', function(e) {
    $(this).toggleClass(fnavChildOpenClass);
    $(this).stop().parent().next('.global-footer-nav-children').slideToggle(400);
    e.preventDefault();
  });

  var $jobsInnerTrigger = $('.js-jobs-work-section01-voice-trigger'),
      jobsInnerOpenClass = 'is-open';
  $jobsInnerTrigger.on('click', function(e) {
    $(this).toggleClass(jobsInnerOpenClass);
    $(this).stop().parent().next('.jobs-work-section01-voice-inner').slideToggle(400);
    e.preventDefault();
  });

  $win.on('load scroll', function() {
    var value = $(this).scrollTop(),
        $header = $('#js-global-header'),
        headerHeight = $header.outerHeight(),
        scrollClass = 'has-scroll';

    if ( value > headerHeight ) {
      $header.addClass(scrollClass);
    } else {
      $header.removeClass(scrollClass);
    }
  });

  var $pagetop = $('#js-pagetop'),
      pagetopShowClass = 'is-show';
  $pagetop.find('a').on('click', function(e) {
    e.preventDefault();
    $('html, body').animate({ scrollTop: 0}, 500, 'linear');
  });
  $win.on('scroll', function() {
    if ( $win.scrollTop() > 200 ) {
      $pagetop.addClass(pagetopShowClass);
    } else {
      $pagetop.removeClass(pagetopShowClass);
    }
  });

  var ua = navigator.userAgent.toLowerCase(),
      isMac = ((ua.indexOf('mac') > -1) && (ua.indexOf('os') > -1)) && !((ua.indexOf('iphone') > -1) || (ua.indexOf('ipad') > -1) || (ua.indexOf('windows') > -1));
  if ( !isMac ) {
    var $document = $(document),
        scrollLength = 400,
        mousewheelevent = 'onwheel' in document ? 'wheel' : 'onmousewheel' in document ? 'mousewheel' : 'DOMMouseScroll';
    $document.on(mousewheelevent, function(e) {
      var delta = e.originalEvent.deltaY ? -(e.originalEvent.deltaY) : e.originalEvent.wheelDelta ? e.originalEvent.wheelDelta : -(e.originalEvent.detail);
      if ( delta < 0 ) {
        var scrollSet =  $document.scrollTop() + scrollLength;
      } else {
        var scrollSet =  $document.scrollTop() - scrollLength;
      }
      $('html, body').stop().animate({scrollTop: scrollSet}, 700, 'easeOutCubic');
      e.preventDefault();
    });
  }

  if ( $('#js-home-hero-slider')[0] ) {
    $('#js-home-hero-slider').bxSlider({
      mode: 'fade',
      speed: 2000,
      // pager: false,
      controls: false,
      auto: true,
      pause: 6000,
      touchEnabled: false,
      onSliderLoad: function() {
        $('.js-first-item-contents').delay(500).queue(function() {
          $(this).removeClass('js-first-item-contents');
        });
      }
    });
  }

  if ( $('#js-privacy-check-1')[0] ) {
    var $submitBtn = $('.form-button-submit');
    if ( $('#js-privacy-check-1').prop('checked') === false ) {
      $submitBtn.prop('disabled', true);
    }
    $('#js-privacy-check-1').on('change', function() {
      if ( $(this).prop('checked') === false ) {
        $submitBtn.prop('disabled', true);
      } else {
        $submitBtn.prop('disabled', false);
      }
    });
  }
});
