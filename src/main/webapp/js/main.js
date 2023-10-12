//emblaNode 변수에 클래스가 embla인 요소를 찾아 할당
var emblaNode = document.querySelector(".embla");
// options 변수에 Embla Carousel의 옵션 객체를 할당하고 loop 옵션을 true로 설정하여 무한루프로 생성
var options = { loop: true };
// autoplay에 EmblaCarouselAutoplay 인스턴스를 생성하여 할당 emblaNode와 delay: 5000을 전달 delay는 슬라이드 간 재생 시간을 나타냄
var autoplay = EmblaCarouselAutoplay(emblaNode, { delay: 5000 });
// embla 변수에 EmblaCarousel 인스턴스를 생성하여 전달 emblaNode와 option 객체, autoplay배열을 전달
var embla = EmblaCarousel(emblaNode, options, [autoplay]);
