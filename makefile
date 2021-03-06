run:
	mvn jetty:run -Dmaven.test.skip=true
package:clean
	mvn package -Dmaven.test.skip=true
clean:
	mvn clean
deploy:
	mvn deploy -Dmaven.test.skip=true
update:
	hg pull && hg update
