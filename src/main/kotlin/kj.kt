

interface KJComponent<PropsT> {
    // A component turns props into a shadow DOM...
    fun render(props: PropsT): ShadowNode
}

class KJButton: KJComponent<KJButton.Props> {
    data class Props(val text: String)
    override fun render(props: KJButton.Props): ShadowNode {
        return ShadowButton(props)
    }
}
