.PHONY: test compile clean

test: compile
	npx jest

compile: target/pigspect.interface.js

clean:
	rm -rf target

target/pigspect.interface.js:
	npx shadow-cljs compile npm
