document.addEventListener('DOMContentLoaded', function() {
    const puestoToggles = document.querySelectorAll('.puesto-desplegar');

    puestoToggles.forEach(toggle => {
        toggle.addEventListener('click', function() {
            const descripcion = this.parentElement.nextElementSibling;
            if (descripcion.classList.contains('hidden')) {
                descripcion.classList.remove('hidden');
                this.textContent = '⯆';
            } else {
                descripcion.classList.add('hidden');
                this.textContent = '⯈';
            }
        });
    });
});
