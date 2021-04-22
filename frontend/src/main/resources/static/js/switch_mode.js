'use strict';


function switch_mode() {
        var button = document.querySelector('#switch_mode_button');
        var els = document.querySelectorAll('.posts');
        var borders = document.querySelectorAll('.border');
        var texts = document.querySelectorAll('.text');
        var cards = document.querySelectorAll('.card');
        var logo = document.querySelector('#logo');
        var img_border = document.querySelectorAll('.img-border');

        var subpub = document.querySelector('#sub-pub');
        var sql = document.querySelector('#sql');
        var dataflow = document.querySelector('#dataflow');
        var bigtable = document.querySelector('#bigtable');
        var bigquery = document.querySelector('#bigquery');
        var appengine = document.querySelector('#app-engine');

        var alert = document.querySelector('#alert');
        var newFeat = document.querySelector('#newfeature');
        var saveButton = document.querySelector('#saveButton');
        var input = document.querySelectorAll('.input');
        var addrows = document.querySelectorAll('.add-row');
        var deleterows = document.querySelectorAll('.delete-row');
        var template = document.querySelector('#template');

        if (button && button.innerHTML == 'Dark') {
            button.innerHTML = 'Light';
            document.body.style.backgroundColor = 'rgb(64,64,64)';

            if(els) {
                els.forEach(el => apply_light(el));
            }
            if(texts) {
                texts.forEach(el => apply_light_text(el));
            }
            if(input) {
                input.forEach(el => apply_light_input(el));
            }
            if(borders) {
                borders.forEach(el => apply_light_border(el));
            }
            if(img_border) {
                img_border.forEach(el => apply_light_img_border(el));
            }
            if(newFeat) {
                newFeat.classList.remove('btn-primary-light');
                newFeat.classList.add('btn-primary-dark');
            }
            if(addrows) {
                addrows.forEach(el => apply_light_addrows(el));
            }
            if(deleterows) {
                deleterows.forEach(el => apply_light_deleterows(el));
            }
            if(template) {
                template.classList.add('template-dark');
            }
            if(saveButton) {
                saveButton.classList.remove('btn-primary-light');
                saveButton.classList.add('btn-primary-dark');
            }
            if(cards) {
                els.forEach(card => apply_light_card(card));
            }
            logo.src = window.location.origin + '/img/logo_dark.png'; 
            
            if(subpub) {
                subpub.src = window.location.origin + '/img/sub-pub-dark.png';
                sql.src = window.location.origin + '/img/sql-dark.png';
                dataflow.src = window.location.origin + '/img/dataflow-dark.png';
                bigtable.src = window.location.origin + '/img/bigtable-dark.png';
                bigquery.src = window.location.origin + '/img/bigquery-dark.png';
                appengine.src = window.location.origin + '/img/app-engine-dark.png';
            }

            if(alert) {
                alert.classList.remove('alert-info-light');
                alert.classList.add('alert-info-dark');
            }
        } else {
            button.innerHTML = 'Dark';
            document.body.style.backgroundColor = '#edeff1';
            if(els) {
                els.forEach(el => apply_dark(el));
            }
            if(texts) {
                texts.forEach(el => apply_dark_text(el));
            }
            if(newFeat) {
                newFeat.classList.remove('btn-primary-dark');
                newFeat.classList.add('btn-primary-light');
            }
            if(saveButton) {
                saveButton.classList.remove('btn-primary-dark');
                saveButton.classList.add('btn-primary-light');
            }
            if(addrows) {
                addrows.forEach(el => apply_dark_addrows(el));
            }
            if(deleterows) {
                deleterows.forEach(el => apply_dark_deleterows(el));
            }
            if(template) {
                template.classList.remove('template-dark');
            }
            if(cards) {
                els.forEach(card => apply_dark_card(card));
            }
            if(borders) {
                borders.forEach(el => apply_dark_border(el));
            }
            if(input) {
                input.forEach(input => apply_dark_input(input));
            }
            if(img_border) {
                img_border.forEach(el => apply_dark_img_border(el));
            }
            logo.src = window.location.origin + '/img/logo_white.png';

            if (subpub) {
                subpub.src = window.location.origin + '/img/sub-pub-light.png';
                sql.src = window.location.origin + '/img/sql-light.png';
                dataflow.src = window.location.origin + '/img/dataflow-light.png';
                bigtable.src = window.location.origin + '/img/bigtable-light.png';
                bigquery.src = window.location.origin + '/img/bigquery-light.png';
                appengine.src = window.location.origin + '/img/app-engine-light.png';
            }

            if(alert){
                alert.classList.remove('alert-info-dark');
                alert.classList.add('alert-info-light');
            }
        }
        
}

function apply_light(el) {
    el.classList.remove('light');
    el.classList.add('dark');                  
}

function apply_dark(el) {
    el.classList.remove('dark');
    el.classList.add('light');              
}


function apply_dark_text(el) {
    el.classList.remove('text-light');
    el.classList.add('text-dark');                  
}

function apply_light_text(el) {
    el.classList.remove('text-dark');
    el.classList.add('text-light');              
}

function apply_light_card(card) {
    card.classList.remove('card-light');
    card.classList.add('card-dark');
}

function apply_dark_card(card) {
    card.classList.remove('card-dark');
    card.classList.add('card-light');
}

function apply_light_input(card) {
    card.classList.remove('input-light');
    card.classList.add('input-dark');
}

function apply_light_border(card) {
    card.classList.add('border-dark');
}


function apply_light_img_border(card) {
    card.classList.remove('img-border-light');
    card.classList.add('img-border-dark');
}

function apply_dark_img_border(card) {
    card.classList.remove('img-border-dark');
    card.classList.add('img-border-light');
}


function apply_dark_border(card) {
    card.classList.remove('border-dark');
}

function apply_light_deleterows(el) {
    el.classList.remove('delete-row-dark');
    el.classList.add('delete-row-light');
}

function apply_light_addrows(el) {
    el.classList.remove('add-row-dark');
    el.classList.add('add-row-light');
}


function apply_dark_deleterows(el) {
    el.classList.remove('delete-row-light');
    el.classList.add('delete-row-dark');
}

function apply_dark_addrows(el) {
    el.classList.remove('add-row-light');
    el.classList.add('add-row-dark');
}

function apply_dark_input(card) {
    card.classList.remove('input-dark');
    card.classList.add('input-light');
}
switch_mode();
