package ytsmovies.romavicdosanjos.com.core.services.helpers

abstract class Mapper<Response, Entity> {
    abstract fun map(data: Response): Entity
}
