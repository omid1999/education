// توابع به صورت محافظت شده تعریف شده اند
//  و توانایی دسترسی غیرمجاز به آنها وجود ندارد
{
    console.log('Student Loaded :)');
    let options = document.querySelectorAll('button');

    options.forEach(element => {
        element.addEventListener('click', function (e) {
            
            let frame = document.querySelector('#frame');

            options.forEach(newEl => {
                newEl.classList.remove("btn-selected");
            });
            element.classList.add("btn-selected");

            switch (e.target.attributes.type.value) {
                case 'choose-ls':
                    frame.src = 'student/choose-ls';
                    break;
                case 'show-ls':
                    frame.src = 'student/show-ls';
                    break;
                case 'show-plan':
                    frame.src = 'student/show-plan';
                    break;
                default:
                    alert('something wrong!');
                    break;
            }
        })
    });
}