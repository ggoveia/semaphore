var gulp = require('gulp');
var concat = require('gulp-concat');
var minifyCSS = require('gulp-minify-css');
var rename = require('gulp-rename');
var inject = require('gulp-inject');
var runSequence = require('run-sequence');
var nodemon = require('gulp-nodemon');

gulp.task('build', function () {
    runSequence('css', 'inject', 'start');
})

gulp.task('css', function () {
    gulp.src('app/js/components/**/css/*.css')
        .pipe(minifyCSS())
        .pipe(concat('styles.min.css'))
        .pipe(gulp.dest('app/css'))
});
gulp.task('inject', function () {
    var target = gulp.src("app/index.html");

    var sourcesPath = [
        'app/js/*.js',
        'app/js/util/**/*.js',
        'app/js/components/semaphore-component/*.js',
        'app/js/components/**/*.js',
    ];

    var sources = gulp.src(sourcesPath, { read: false }, { relative: true });

    return target.pipe(inject(sources))
        .pipe(gulp.dest('app'));
})

gulp.task('start', function () {
  nodemon({
    script: 'serve.js'
  , ext: 'js html'
  , env: { 'NODE_ENV': 'development' }
  })
})