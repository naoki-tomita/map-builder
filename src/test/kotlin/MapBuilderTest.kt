import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MapBuilderTest {

    @Test
    fun `It should create map`() {
        MapBuilder().put("foo", "bar").build() shouldBeEqualTo mapOf("foo" to "bar")
    }

    @Test
    fun `It should create multiple key value map`() {
        MapBuilder()
            .put("foo", "bar")
            .put("hoge", "fuga")
            .build()
            .shouldBeEqualTo(
                mapOf(
                    "foo" to "bar",
                    "hoge" to "fuga"
                )
            )
    }

    @Test
    fun `It should create nested map`() {
        MapBuilder()
            .put("foo.bar", "hoge")
            .build()
            .shouldBeEqualTo(
                mapOf(
                    "foo" to mapOf("bar" to "hoge")
                )
            )
    }

    @Test
    fun `It should create multiple nested map`() {
        MapBuilder()
            .put("foo.bar.hoge", "hoge")
            .put("foo.bar.fuga", "fuga")
            .build()
            .shouldBeEqualTo(
                mapOf(
                    "foo" to mapOf(
                        "bar" to mapOf(
                            "hoge" to "hoge",
                            "fuga" to "fuga"
                        )
                    )
                )
            )
    }

    @Test
    fun `It should create complexed map`() {
        MapBuilder()
            .put("foo.bar.hoge", "hoge")
            .put("foo.hoge", "fuga")
            .put("hoge.fuga", "piyo")
            .build()
            .shouldBeEqualTo(
                mapOf(
                    "foo" to mapOf(
                        "bar" to mapOf(
                            "hoge" to "hoge"
                        ),
                        "hoge" to "fuga"
                    ),
                    "hoge" to mapOf(
                        "fuga" to "piyo"
                    )
                )
            )
    }

}