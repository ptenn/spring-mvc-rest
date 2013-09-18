// js/collections/propertyList.js

var app = app || {};

app.PropertyList = Backbone.Collection.extend({
    model: app.Property,
    url: '/properties'
});