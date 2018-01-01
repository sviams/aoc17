
object AoC_Day7 {

    data class TreeNode(val name: String, val weight: Int, val totalWeight: Int, val children: List<String>)

    private fun parseUnweighted(input: List<String>) : List<TreeNode> =
        input.map {
            val split = it.split(" ")
            TreeNode(split[0], split[1].substring(1, split[1].length - 1).toInt(), 0, if (split.size > 2) split.subList(3,split.size).map { it.trim(',') } else listOf())
        }

    private fun mapWeights(tree: List<TreeNode>) : List<TreeNode> =
        tree.map { TreeNode(it.name, it.weight, it.weight + resolveChildrenWeight(tree, it), it.children) }

    private fun resolveChildrenWeight(all: List<TreeNode>, current: TreeNode) : Int {
        val children = all.filter { current.children.contains(it.name) }
        return children.fold(0) {acc, value ->  acc + value.weight +  resolveChildrenWeight(all, value) }
    }

    private tailrec fun balanceChildren(all: List<TreeNode>, node: TreeNode, lastDiff: Int) : Int {
        val children = all.filter { node.children.contains(it.name) }
        val childWeights = children.map { it.totalWeight }
        val unbalancedChild = children.firstOrNull { child -> childWeights.count { it == child.totalWeight } == 1 }
        return if (unbalancedChild == null)
            node.weight - lastDiff
        else
            balanceChildren(all, unbalancedChild, childWeights.max()!! - childWeights.min()!!)
    }

    fun solvePt1(input: List<String>) : String {
        val weightedTree = mapWeights(parseUnweighted(input))
        return weightedTree.maxBy { it.totalWeight }!!.name
    }

    fun solvePt2(input: List<String>) : Int {
        val newTree = mapWeights(parseUnweighted(input))
        val rootName = newTree.maxBy { it.totalWeight }!!.name
        val rootNode = newTree.firstOrNull { it.name == rootName }!!
        return balanceChildren(newTree, rootNode, 0)

    }

}