import spock.lang.Specification

abstract class GenericSpecification extends Specification {

    // initialized only ONCE over all threads (important for parallelization)
    def static beforeAll = new BeforeAll()

}
