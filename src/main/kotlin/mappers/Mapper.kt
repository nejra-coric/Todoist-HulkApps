package mappers

interface Mapper<D, E> {
    fun fromEntity(entity: E): D
    fun fromDTO(domain: D): E
}