// توابع به صورت محافظت شده تعریف شده اند
//  و توانایی دسترسی غیرمجاز به آنها وجود ندارد

{
    console.log('Master Loaded :)');
    let options = document.querySelectorAll('button');

    options.forEach(element => {
        element.addEventListener('click', function (e) {

            let frame = document.querySelector('#frame');

            options.forEach(newEl => {
                newEl.classList.remove("btn-selected");
            });
            element.classList.add("btn-selected");

            switch (e.target.attributes.type.value) {
                case 'show-plan':
                    frame.src = 'master/show-plan';
                    break;
                case 'insert-grade':
                    frame.src = 'master/insert-grade';
                    break;
                default:
                    alert('something wrong!');
                    break;
            }
        })
    });
}