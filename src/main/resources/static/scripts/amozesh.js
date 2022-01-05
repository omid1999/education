// توابع به صورت محافظت شده تعریف شده اند
//  و توانایی دسترسی غیرمجاز به آنها وجود ندارد

{
    console.log('Amozesh Loaded :)');
    let options = document.querySelectorAll('button');

    options.forEach(element => {
        element.addEventListener('click', function (e) {
            
            let frame = document.querySelector('#frame');

            options.forEach(newEl => {
                newEl.classList.remove("btn-selected");
            });
            element.classList.add("btn-selected");

            switch (e.target.attributes.type.value) {
                case 'make-st':
                    frame.src = 'amozesh/make-st';
                    break;
                case 'edit-st':
                    frame.src = 'amozesh/edit-st';
                    break;
                case 'make-ms':
                    frame.src = 'amozesh/make-ms';
                    break;
                case 'edit-ms':
                    frame.src = 'amozesh/edit-ms';
                    break;
                case 'make-ls':
                    frame.src = 'amozesh/make-ls';
                    break;
                case 'edit-ls':
                    frame.src = 'amozesh/edit-ls';
                    break;
                case 'enable-uc':
                    frame.src = 'amozesh/enable-uc';
                    break;

                default:
                    alert('something wrong!');
                    break;
            }
        })
    });
}