var app = app || {};

app.PropertyListView = Backbone.View.extend({
	el: $( '#properties' ),

	initialize: function() {
		this.collection = new app.PropertyList();
		this.collection.fetch();
		this.render();

		this.listenTo( this.collection, 'add', this.renderProperty );
		this.listenTo( this.collection, 'reset', this.render );
	},

	events: {
		'click #add': 'addProperty'
	},

	addProperty: function( e ) {
		e.preventDefault();

		var formData = {};

		$( '#addProperty div' ).children( 'input' ).each( function( i, el ) {
			if( $( el ).val() != "" )
			{
//				if( el.id === 'keywords' ) {
//					formData[ el.id ] = [];
//					_.each( $( el ).val().split( ' ' ), function( keyword ) {
//						formData[ el.id ].push({ 'keyword': keyword });
//					});
//				} else if( el.id === 'releaseDate' ) {
//					formData[ el.id ] = $( '#releaseDate' ).datepicker( 'getDate' ).getTime();
//				} else {
//					formData[ el.id ] = $( el ).val();
//				}
				formData[ el.id ] = $( el ).val();
			}
		});

		this.collection.create( formData );
	},

	// render library by rendering each book in its collection
	render: function() {
		this.collection.each(function( item ) {
			this.renderProperty( item );
		}, this );
	},

	// render a book by creating a BookView and appending the
	// element it renders to the library's element
	renderProperty: function( item ) {
		var propertyView = new app.PropertyView({
			model: item
		});
		this.$el.append( propertyView.render().el );
	}
});
