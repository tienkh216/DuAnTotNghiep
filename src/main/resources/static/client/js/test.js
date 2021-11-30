const mySlideV = new SlideV()

const next = document.querySelector('.next')
const prev = document.querySelector('.prev')

next.addEventListener('click', () => { mySlideV.next() })
prev.addEventListener('click', () => { mySlideV.prev() })

