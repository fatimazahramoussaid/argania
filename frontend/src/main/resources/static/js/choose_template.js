'use strict';

function onclick_template(value) {
    if(value == 'naming_rules') {
        window.location.href = '/namingrules';
        return;
    }
    if(value == 'glossary') {
        window.location.href = '/glossary';
        return;
    }
    if(value == 'switch_view_button') {
        window.location.href = '/switchviewbutton';
        return;
    }
    if(value == 'export_button') {
        window.location.href = '/exportbutton';
        return;
    }

}

function choose_template() {
    var button = document.querySelector('#template');
    if(button) {
        var value = button.value;
        const list_templates = [
            'restful_api',
            'data_transformation', 
            'database',
            'web_page',
            'batch_process',
            'naming_rules',
            'manueloperations',
            'glossary'
        ];

        if(value == 'cloud_design') {
            window.location.href = '/clouddesign';
            return;
        }
        if(value == 'manueloperations') {
            window.location.href = '/manueloperations';
            return;
        }
        if(value == 'data_transformation') {
            window.location.href = '/datatransformation';
            return;
        }
        if(value == 'restful_api') {
            window.location.href = '/restapi';
            return;
        }
        if(value == 'database') {
            window.location.href = '/database';
            return;
        }
        if(value == 'freestyle') {
            window.location.href = '/freestyle';
            return;
        }
        if(value == 'freestyle') {
            window.location.href = '/freestyle';
            return;
        }
        if(value == 'web_page') {
            window.location.href = '/webpage';
            return;
        }
        if(value == 'batch_process') {
            window.location.href = '/batchprocess';
            return;
        }
        if(value == 'batch_process') {
            window.location.href = '/batchprocess';
            return;
        }
    }

}

choose_template();
