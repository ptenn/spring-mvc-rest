// js/models/property.js

var app = app || {};

app.Book = Backbone.Model.extend({
    defaults: {
        address1: '',
        address2: '',
        city: '',
        state: '',
        zip: ''
    }
});