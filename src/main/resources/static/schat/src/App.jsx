import Header from "./components/header/Header";
import Sidebar from "./components/sidebar/Sidebar";
import "./components/header/Header.css";
import "./App.css";

export default function App() {
  return (
    <div>
      <Header />
      <main>
        <Sidebar />
      </main>
    </div>
  );
}
