# React - a Javascript Frontend Library

## 1. Introduction

React adalah library JavaScript untuk membangun user interface, dikembangkan oleh Meta (Facebook). React menggunakan component-based architecture dan virtual DOM untuk performa optimal.

**Key Characteristics:**
- Declarative programming model
- Component-based architecture
- Virtual DOM untuk efisiensi rendering
- Unidirectional data flow
- JSX syntax

---

## 2. Core Concepts

### 2.1 JSX (JavaScript XML)

JSX adalah syntax extension untuk JavaScript yang memungkinkan penulisan HTML-like code dalam JavaScript.

**Basic Syntax:**
```jsx
const element = <h1>Hello, World!</h1>;

// With expressions
const name = "John";
const greeting = <h1>Hello, {name}!</h1>;

// Multi-line
const component = (
  <div>
    <h1>Title</h1>
    <p>Content</p>
  </div>
);
```

**JSX Rules:**
- Single parent element required
- Use `className` instead of `class`
- Use `htmlFor` instead of `for`
- camelCase for attributes (`onClick`, `onChange`)
- Self-closing tags must include `/`

**Expressions in JSX:**
```jsx
const user = { name: "Alice", age: 25 };
const element = (
  <div>
    <h1>{user.name}</h1>
    <p>Age: {user.age}</p>
    <p>{user.age >= 18 ? "Adult" : "Minor"}</p>
  </div>
);
```

### 2.2 Components

**Function Components:**
```jsx
function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}

// Arrow function
const Welcome = (props) => {
  return <h1>Hello, {props.name}</h1>;
};

// Destructuring props
const Welcome = ({ name, age }) => {
  return (
    <div>
      <h1>Hello, {name}</h1>
      <p>Age: {age}</p>
    </div>
  );
};
```

**Class Components (Legacy):**
```jsx
class Welcome extends React.Component {
  render() {
    return <h1>Hello, {this.props.name}</h1>;
  }
}
```

**Component Composition:**
```jsx
function App() {
  return (
    <div>
      <Welcome name="Alice" />
      <Welcome name="Bob" />
      <Welcome name="Charlie" />
    </div>
  );
}
```

### 2.3 Props

Props adalah data yang diteruskan dari parent ke child component. Props bersifat read-only.

**Basic Props:**
```jsx
function UserCard({ name, email, avatar }) {
  return (
    <div className="card">
      <img src={avatar} alt={name} />
      <h2>{name}</h2>
      <p>{email}</p>
    </div>
  );
}

// Usage
<UserCard 
  name="John Doe" 
  email="john@example.com" 
  avatar="/john.jpg" 
/>
```

**Default Props:**
```jsx
function Button({ text, type = "button", disabled = false }) {
  return <button type={type} disabled={disabled}>{text}</button>;
}
```

**Children Props:**
```jsx
function Card({ children, title }) {
  return (
    <div className="card">
      <h2>{title}</h2>
      <div className="content">{children}</div>
    </div>
  );
}

// Usage
<Card title="My Card">
  <p>This is the content</p>
  <button>Click me</button>
</Card>
```

**Prop Types (validation):**
```jsx
import PropTypes from 'prop-types';

function UserCard({ name, age, email }) {
  return <div>{name} - {age} - {email}</div>;
}

UserCard.propTypes = {
  name: PropTypes.string.isRequired,
  age: PropTypes.number.isRequired,
  email: PropTypes.string
};

UserCard.defaultProps = {
  email: 'no-email@example.com'
};
```

### 2.4 State

State adalah data internal component yang bisa berubah. Perubahan state trigger re-render.

**useState Hook:**
```jsx
import { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
      <button onClick={() => setCount(count - 1)}>Decrement</button>
      <button onClick={() => setCount(0)}>Reset</button>
    </div>
  );
}
```

**Multiple State Variables:**
```jsx
function Form() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [age, setAge] = useState(0);

  return (
    <form>
      <input value={name} onChange={(e) => setName(e.target.value)} />
      <input value={email} onChange={(e) => setEmail(e.target.value)} />
      <input value={age} onChange={(e) => setAge(Number(e.target.value))} />
    </form>
  );
}
```

**Object State:**
```jsx
function UserForm() {
  const [user, setUser] = useState({
    name: '',
    email: '',
    age: 0
  });

  const handleChange = (field, value) => {
    setUser(prev => ({
      ...prev,
      [field]: value
    }));
  };

  return (
    <form>
      <input 
        value={user.name} 
        onChange={(e) => handleChange('name', e.target.value)} 
      />
      <input 
        value={user.email} 
        onChange={(e) => handleChange('email', e.target.value)} 
      />
    </form>
  );
}
```

**Array State:**
```jsx
function TodoList() {
  const [todos, setTodos] = useState([]);
  const [input, setInput] = useState('');

  const addTodo = () => {
    setTodos([...todos, { id: Date.now(), text: input }]);
    setInput('');
  };

  const removeTodo = (id) => {
    setTodos(todos.filter(todo => todo.id !== id));
  };

  return (
    <div>
      <input value={input} onChange={(e) => setInput(e.target.value)} />
      <button onClick={addTodo}>Add</button>
      <ul>
        {todos.map(todo => (
          <li key={todo.id}>
            {todo.text}
            <button onClick={() => removeTodo(todo.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
```

**Functional Updates:**
```jsx
function Counter() {
  const [count, setCount] = useState(0);

  const incrementTwice = () => {
    // Wrong way - both use same state value
    // setCount(count + 1);
    // setCount(count + 1);

    // Correct way - use functional update
    setCount(prev => prev + 1);
    setCount(prev => prev + 1);
  };

  return <button onClick={incrementTwice}>+2</button>;
}
```

---

## 3. Lifecycle & Effects

### 3.1 useEffect Hook

useEffect menangani side effects seperti data fetching, subscriptions, manual DOM manipulation.

**Basic Usage:**
```jsx
import { useEffect, useState } from 'react';

function Component() {
  const [data, setData] = useState(null);

  // Runs after every render
  useEffect(() => {
    console.log('Component rendered');
  });

  // Runs once on mount
  useEffect(() => {
    console.log('Component mounted');
  }, []);

  // Runs when dependency changes
  useEffect(() => {
    console.log('Data changed:', data);
  }, [data]);

  return <div>{data}</div>;
}
```

**Cleanup Function:**
```jsx
function Timer() {
  const [seconds, setSeconds] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      setSeconds(prev => prev + 1);
    }, 1000);

    // Cleanup function
    return () => {
      clearInterval(interval);
    };
  }, []);

  return <div>Seconds: {seconds}</div>;
}
```

**Data Fetching:**
```jsx
function UserProfile({ userId }) {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    let cancelled = false;

    const fetchUser = async () => {
      try {
        setLoading(true);
        const response = await fetch(`/api/users/${userId}`);
        const data = await response.json();

        if (!cancelled) {
          setUser(data);
          setError(null);
        }
      } catch (err) {
        if (!cancelled) {
          setError(err.message);
        }
      } finally {
        if (!cancelled) {
          setLoading(false);
        }
      }
    };

    fetchUser();

    return () => {
      cancelled = true;
    };
  }, [userId]);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;
  return <div>{user?.name}</div>;
}
```

### 3.2 useLayoutEffect

Sama seperti useEffect tetapi fires synchronously setelah semua DOM mutations. Gunakan untuk DOM measurements.

```jsx
import { useLayoutEffect, useRef, useState } from 'react';

function TooltipComponent() {
  const ref = useRef(null);
  const [tooltipHeight, setTooltipHeight] = useState(0);

  useLayoutEffect(() => {
    const { height } = ref.current.getBoundingClientRect();
    setTooltipHeight(height);
  }, []);

  return <div ref={ref}>Tooltip</div>;
}
```

### 3.3 Class Component Lifecycle (Legacy)

**Mounting:**
```jsx
class Component extends React.Component {
  constructor(props) {
    super(props);
    this.state = { data: null };
  }

  componentDidMount() {
    // Runs after first render
    this.fetchData();
  }

  render() {
    return <div>{this.state.data}</div>;
  }
}
```

**Updating:**
```jsx
class Component extends React.Component {
  componentDidUpdate(prevProps, prevState) {
    if (this.props.userId !== prevProps.userId) {
      this.fetchData();
    }
  }

  render() {
    return <div>{this.state.data}</div>;
  }
}
```

**Unmounting:**
```jsx
class Component extends React.Component {
  componentWillUnmount() {
    // Cleanup
    clearInterval(this.timer);
  }
}
```

---

## 4. Event Handling

**Basic Events:**
```jsx
function EventExample() {
  const handleClick = (e) => {
    e.preventDefault();
    console.log('Clicked!');
  };

  const handleChange = (e) => {
    console.log(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Submitted');
  };

  return (
    <div>
      <button onClick={handleClick}>Click</button>
      <input onChange={handleChange} />
      <form onSubmit={handleSubmit}>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}
```

**Event with Parameters:**
```jsx
function List() {
  const handleClick = (id, e) => {
    console.log('Clicked item:', id);
  };

  const items = [1, 2, 3];

  return (
    <ul>
      {items.map(id => (
        <li key={id} onClick={(e) => handleClick(id, e)}>
          Item {id}
        </li>
      ))}
    </ul>
  );
}
```

**Keyboard Events:**
```jsx
function KeyboardExample() {
  const handleKeyPress = (e) => {
    if (e.key === 'Enter') {
      console.log('Enter pressed');
    }
  };

  const handleKeyDown = (e) => {
    if (e.ctrlKey && e.key === 's') {
      e.preventDefault();
      console.log('Ctrl+S pressed');
    }
  };

  return (
    <input 
      onKeyPress={handleKeyPress}
      onKeyDown={handleKeyDown}
    />
  );
}
```

**Mouse Events:**
```jsx
function MouseExample() {
  const [position, setPosition] = useState({ x: 0, y: 0 });

  const handleMouseMove = (e) => {
    setPosition({ x: e.clientX, y: e.clientY });
  };

  return (
    <div 
      onMouseMove={handleMouseMove}
      onMouseEnter={() => console.log('Enter')}
      onMouseLeave={() => console.log('Leave')}
    >
      Position: {position.x}, {position.y}
    </div>
  );
}
```

---

## 5. Conditional Rendering

**If/Else with &&:**
```jsx
function Greeting({ isLoggedIn, username }) {
  return (
    <div>
      {isLoggedIn && <h1>Welcome, {username}!</h1>}
      {!isLoggedIn && <h1>Please log in</h1>}
    </div>
  );
}
```

**Ternary Operator:**
```jsx
function Status({ isLoading, error, data }) {
  return (
    <div>
      {isLoading ? (
        <Spinner />
      ) : error ? (
        <ErrorMessage error={error} />
      ) : (
        <DataDisplay data={data} />
      )}
    </div>
  );
}
```

**Early Return:**
```jsx
function UserProfile({ user }) {
  if (!user) {
    return <div>No user found</div>;
  }

  if (user.banned) {
    return <div>User is banned</div>;
  }

  return (
    <div>
      <h1>{user.name}</h1>
      <p>{user.email}</p>
    </div>
  );
}
```

**Switch Case Pattern:**
```jsx
function StatusDisplay({ status }) {
  const renderStatus = () => {
    switch(status) {
      case 'loading':
        return <Spinner />;
      case 'error':
        return <ErrorMessage />;
      case 'success':
        return <SuccessMessage />;
      default:
        return null;
    }
  };

  return <div>{renderStatus()}</div>;
}
```

**Enum Pattern:**
```jsx
const STATUS_COMPONENTS = {
  loading: Spinner,
  error: ErrorMessage,
  success: SuccessMessage
};

function StatusDisplay({ status }) {
  const Component = STATUS_COMPONENTS[status];
  return Component ? <Component /> : null;
}
```

---

## 6. Lists & Keys

**Basic List Rendering:**
```jsx
function UserList({ users }) {
  return (
    <ul>
      {users.map(user => (
        <li key={user.id}>
          {user.name} - {user.email}
        </li>
      ))}
    </ul>
  );
}
```

**List with Components:**
```jsx
function TodoList({ todos }) {
  return (
    <div>
      {todos.map(todo => (
        <TodoItem 
          key={todo.id} 
          todo={todo}
          onDelete={() => handleDelete(todo.id)}
        />
      ))}
    </div>
  );
}
```

**Filtered Lists:**
```jsx
function ProductList({ products, filter }) {
  const filteredProducts = products.filter(product => 
    product.category === filter
  );

  return (
    <div>
      {filteredProducts.map(product => (
        <ProductCard key={product.id} product={product} />
      ))}
    </div>
  );
}
```

**List with Index (avoid if possible):**
```jsx
// Only use index as key if items have no unique id and list never reorders
function StaticList({ items }) {
  return (
    <ul>
      {items.map((item, index) => (
        <li key={index}>{item}</li>
      ))}
    </ul>
  );
}
```

**Nested Lists:**
```jsx
function CategoryList({ categories }) {
  return (
    <div>
      {categories.map(category => (
        <div key={category.id}>
          <h2>{category.name}</h2>
          <ul>
            {category.items.map(item => (
              <li key={item.id}>{item.name}</li>
            ))}
          </ul>
        </div>
      ))}
    </div>
  );
}
```

---

## 7. Forms

**Controlled Components:**
```jsx
function LoginForm() {
  const [formData, setFormData] = useState({
    email: '',
    password: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Submit:', formData);
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        name="email"
        type="email"
        value={formData.email}
        onChange={handleChange}
      />
      <input
        name="password"
        type="password"
        value={formData.password}
        onChange={handleChange}
      />
      <button type="submit">Login</button>
    </form>
  );
}
```

**Uncontrolled Components (useRef):**
```jsx
function UncontrolledForm() {
  const emailRef = useRef(null);
  const passwordRef = useRef(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log({
      email: emailRef.current.value,
      password: passwordRef.current.value
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <input ref={emailRef} type="email" />
      <input ref={passwordRef} type="password" />
      <button type="submit">Login</button>
    </form>
  );
}
```

**Checkbox & Radio:**
```jsx
function PreferencesForm() {
  const [preferences, setPreferences] = useState({
    newsletter: false,
    notifications: false,
    theme: 'light'
  });

  const handleCheckbox = (e) => {
    const { name, checked } = e.target;
    setPreferences(prev => ({ ...prev, [name]: checked }));
  };

  const handleRadio = (e) => {
    setPreferences(prev => ({ ...prev, theme: e.target.value }));
  };

  return (
    <form>
      <label>
        <input
          type="checkbox"
          name="newsletter"
          checked={preferences.newsletter}
          onChange={handleCheckbox}
        />
        Newsletter
      </label>

      <label>
        <input
          type="radio"
          name="theme"
          value="light"
          checked={preferences.theme === 'light'}
          onChange={handleRadio}
        />
        Light
      </label>
      <label>
        <input
          type="radio"
          name="theme"
          value="dark"
          checked={preferences.theme === 'dark'}
          onChange={handleRadio}
        />
        Dark
      </label>
    </form>
  );
}
```

**Select Dropdown:**
```jsx
function CountrySelector() {
  const [country, setCountry] = useState('');

  const countries = ['USA', 'UK', 'Indonesia', 'Japan'];

  return (
    <select value={country} onChange={(e) => setCountry(e.target.value)}>
      <option value="">Select Country</option>
      {countries.map(c => (
        <option key={c} value={c}>{c}</option>
      ))}
    </select>
  );
}
```

**Form Validation:**
```jsx
function ValidatedForm() {
  const [formData, setFormData] = useState({ email: '', password: '' });
  const [errors, setErrors] = useState({});

  const validate = () => {
    const newErrors = {};

    if (!formData.email.includes('@')) {
      newErrors.email = 'Invalid email';
    }

    if (formData.password.length < 6) {
      newErrors.password = 'Password must be at least 6 characters';
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      console.log('Valid form:', formData);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        name="email"
        value={formData.email}
        onChange={(e) => setFormData({...formData, email: e.target.value})}
      />
      {errors.email && <span className="error">{errors.email}</span>}

      <input
        name="password"
        type="password"
        value={formData.password}
        onChange={(e) => setFormData({...formData, password: e.target.value})}
      />
      {errors.password && <span className="error">{errors.password}</span>}

      <button type="submit">Submit</button>
    </form>
  );
}
```

---

## 8. Hooks

### 8.1 useRef

useRef menyimpan mutable value yang tidak trigger re-render. Umum untuk DOM access dan mutable values.

**DOM Access:**
```jsx
function TextInput() {
  const inputRef = useRef(null);

  const focusInput = () => {
    inputRef.current.focus();
  };

  return (
    <div>
      <input ref={inputRef} />
      <button onClick={focusInput}>Focus Input</button>
    </div>
  );
}
```

**Mutable Value Storage:**
```jsx
function Timer() {
  const [count, setCount] = useState(0);
  const intervalRef = useRef(null);

  const start = () => {
    if (!intervalRef.current) {
      intervalRef.current = setInterval(() => {
        setCount(c => c + 1);
      }, 1000);
    }
  };

  const stop = () => {
    clearInterval(intervalRef.current);
    intervalRef.current = null;
  };

  useEffect(() => {
    return () => stop();
  }, []);

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={start}>Start</button>
      <button onClick={stop}>Stop</button>
    </div>
  );
}
```

**Previous Value Tracking:**
```jsx
function usePrevious(value) {
  const ref = useRef();

  useEffect(() => {
    ref.current = value;
  }, [value]);

  return ref.current;
}

function Counter() {
  const [count, setCount] = useState(0);
  const prevCount = usePrevious(count);

  return (
    <div>
      <p>Current: {count}</p>
      <p>Previous: {prevCount}</p>
      <button onClick={() => setCount(count + 1)}>+</button>
    </div>
  );
}
```

### 8.2 useContext

Context menyediakan cara untuk passing data through component tree tanpa props drilling.

**Creating Context:**
```jsx
import { createContext, useContext, useState } from 'react';

const ThemeContext = createContext();

function ThemeProvider({ children }) {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme(prev => prev === 'light' ? 'dark' : 'light');
  };

  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      {children}
    </ThemeContext.Provider>
  );
}

function useTheme() {
  const context = useContext(ThemeContext);
  if (!context) {
    throw new Error('useTheme must be used within ThemeProvider');
  }
  return context;
}

// Usage
function App() {
  return (
    <ThemeProvider>
      <Header />
      <Content />
    </ThemeProvider>
  );
}

function Header() {
  const { theme, toggleTheme } = useTheme();

  return (
    <header className={theme}>
      <button onClick={toggleTheme}>Toggle Theme</button>
    </header>
  );
}
```

**Auth Context Example:**
```jsx
const AuthContext = createContext();

function AuthProvider({ children }) {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Check auth status
    checkAuth().then(user => {
      setUser(user);
      setLoading(false);
    });
  }, []);

  const login = async (credentials) => {
    const user = await api.login(credentials);
    setUser(user);
  };

  const logout = () => {
    api.logout();
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, login, logout, loading }}>
      {children}
    </AuthContext.Provider>
  );
}

function useAuth() {
  return useContext(AuthContext);
}
```

### 8.3 useReducer

Alternative untuk useState untuk state logic yang complex. Mirip Redux pattern.

**Basic useReducer:**
```jsx
import { useReducer } from 'react';

const initialState = { count: 0 };

function reducer(state, action) {
  switch (action.type) {
    case 'increment':
      return { count: state.count + 1 };
    case 'decrement':
      return { count: state.count - 1 };
    case 'reset':
      return initialState;
    default:
      throw new Error('Unknown action type');
  }
}

function Counter() {
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <div>
      <p>Count: {state.count}</p>
      <button onClick={() => dispatch({ type: 'increment' })}>+</button>
      <button onClick={() => dispatch({ type: 'decrement' })}>-</button>
      <button onClick={() => dispatch({ type: 'reset' })}>Reset</button>
    </div>
  );
}
```

**Complex State Management:**
```jsx
const initialState = {
  todos: [],
  filter: 'all'
};

function todoReducer(state, action) {
  switch (action.type) {
    case 'ADD_TODO':
      return {
        ...state,
        todos: [...state.todos, {
          id: Date.now(),
          text: action.payload,
          completed: false
        }]
      };

    case 'TOGGLE_TODO':
      return {
        ...state,
        todos: state.todos.map(todo =>
          todo.id === action.payload
            ? { ...todo, completed: !todo.completed }
            : todo
        )
      };

    case 'DELETE_TODO':
      return {
        ...state,
        todos: state.todos.filter(todo => todo.id !== action.payload)
      };

    case 'SET_FILTER':
      return {
        ...state,
        filter: action.payload
      };

    default:
      return state;
  }
}

function TodoApp() {
  const [state, dispatch] = useReducer(todoReducer, initialState);

  const addTodo = (text) => {
    dispatch({ type: 'ADD_TODO', payload: text });
  };

  const toggleTodo = (id) => {
    dispatch({ type: 'TOGGLE_TODO', payload: id });
  };

  return <div>{/* UI */}</div>;
}
```

### 8.4 useMemo

Memoize computed values untuk optimize performance. Hanya recompute ketika dependencies berubah.

**Basic Usage:**
```jsx
import { useMemo, useState } from 'react';

function ExpensiveComponent({ items }) {
  const [filter, setFilter] = useState('');

  const filteredItems = useMemo(() => {
    console.log('Filtering items...');
    return items.filter(item => 
      item.name.toLowerCase().includes(filter.toLowerCase())
    );
  }, [items, filter]);

  return (
    <div>
      <input value={filter} onChange={(e) => setFilter(e.target.value)} />
      <ul>
        {filteredItems.map(item => (
          <li key={item.id}>{item.name}</li>
        ))}
      </ul>
    </div>
  );
}
```

**Complex Calculations:**
```jsx
function DataTable({ data, sortBy, sortOrder }) {
  const sortedData = useMemo(() => {
    console.log('Sorting data...');

    return [...data].sort((a, b) => {
      const aVal = a[sortBy];
      const bVal = b[sortBy];

      if (sortOrder === 'asc') {
        return aVal > bVal ? 1 : -1;
      } else {
        return aVal < bVal ? 1 : -1;
      }
    });
  }, [data, sortBy, sortOrder]);

  return (
    <table>
      {sortedData.map(row => (
        <tr key={row.id}>
          <td>{row.name}</td>
          <td>{row.value}</td>
        </tr>
      ))}
    </table>
  );
}
```

### 8.5 useCallback

Memoize function reference untuk prevent unnecessary re-renders pada child components.

**Basic Usage:**
```jsx
import { useCallback, useState } from 'react';

function ParentComponent() {
  const [count, setCount] = useState(0);
  const [text, setText] = useState('');

  // Without useCallback, this function recreated setiap render
  const handleClick = useCallback(() => {
    console.log('Button clicked');
    setCount(c => c + 1);
  }, []); // Empty deps = function never recreated

  const handleReset = useCallback(() => {
    setCount(0);
  }, []);

  return (
    <div>
      <input value={text} onChange={(e) => setText(e.target.value)} />
      <p>Count: {count}</p>
      <ExpensiveChild onClick={handleClick} onReset={handleReset} />
    </div>
  );
}

const ExpensiveChild = React.memo(({ onClick, onReset }) => {
  console.log('ExpensiveChild rendered');
  return (
    <div>
      <button onClick={onClick}>Click</button>
      <button onClick={onReset}>Reset</button>
    </div>
  );
});
```

**With Dependencies:**
```jsx
function SearchComponent({ onSearch }) {
  const [query, setQuery] = useState('');
  const [filters, setFilters] = useState({});

  const handleSearch = useCallback(() => {
    onSearch(query, filters);
  }, [query, filters, onSearch]);

  return (
    <div>
      <input value={query} onChange={(e) => setQuery(e.target.value)} />
      <button onClick={handleSearch}>Search</button>
    </div>
  );
}
```

### 8.6 Custom Hooks

Custom hooks adalah reusable logic yang menggunakan built-in hooks.

**useFetch Hook:**
```jsx
function useFetch(url) {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    let cancelled = false;

    const fetchData = async () => {
      try {
        setLoading(true);
        const response = await fetch(url);
        const json = await response.json();

        if (!cancelled) {
          setData(json);
          setError(null);
        }
      } catch (err) {
        if (!cancelled) {
          setError(err.message);
        }
      } finally {
        if (!cancelled) {
          setLoading(false);
        }
      }
    };

    fetchData();

    return () => {
      cancelled = true;
    };
  }, [url]);

  return { data, loading, error };
}

// Usage
function UserProfile({ userId }) {
  const { data: user, loading, error } = useFetch(`/api/users/${userId}`);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;
  return <div>{user.name}</div>;
}
```

**useLocalStorage Hook:**
```jsx
function useLocalStorage(key, initialValue) {
  const [storedValue, setStoredValue] = useState(() => {
    try {
      const item = window.localStorage.getItem(key);
      return item ? JSON.parse(item) : initialValue;
    } catch (error) {
      console.error(error);
      return initialValue;
    }
  });

  const setValue = (value) => {
    try {
      const valueToStore = value instanceof Function 
        ? value(storedValue) 
        : value;

      setStoredValue(valueToStore);
      window.localStorage.setItem(key, JSON.stringify(valueToStore));
    } catch (error) {
      console.error(error);
    }
  };

  return [storedValue, setValue];
}

// Usage
function App() {
  const [theme, setTheme] = useLocalStorage('theme', 'light');

  return (
    <div className={theme}>
      <button onClick={() => setTheme(theme === 'light' ? 'dark' : 'light')}>
        Toggle Theme
      </button>
    </div>
  );
}
```

**useDebounce Hook:**
```jsx
function useDebounce(value, delay) {
  const [debouncedValue, setDebouncedValue] = useState(value);

  useEffect(() => {
    const handler = setTimeout(() => {
      setDebouncedValue(value);
    }, delay);

    return () => {
      clearTimeout(handler);
    };
  }, [value, delay]);

  return debouncedValue;
}

// Usage
function SearchComponent() {
  const [searchTerm, setSearchTerm] = useState('');
  const debouncedSearchTerm = useDebounce(searchTerm, 500);

  useEffect(() => {
    if (debouncedSearchTerm) {
      // API call
      console.log('Searching for:', debouncedSearchTerm);
    }
  }, [debouncedSearchTerm]);

  return (
    <input 
      value={searchTerm} 
      onChange={(e) => setSearchTerm(e.target.value)} 
    />
  );
}
```

**useToggle Hook:**
```jsx
function useToggle(initialValue = false) {
  const [value, setValue] = useState(initialValue);

  const toggle = useCallback(() => {
    setValue(v => !v);
  }, []);

  return [value, toggle];
}

// Usage
function Modal() {
  const [isOpen, toggleOpen] = useToggle(false);

  return (
    <div>
      <button onClick={toggleOpen}>Toggle Modal</button>
      {isOpen && <div className="modal">Modal Content</div>}
    </div>
  );
}
```

**useWindowSize Hook:**
```jsx
function useWindowSize() {
  const [windowSize, setWindowSize] = useState({
    width: undefined,
    height: undefined,
  });

  useEffect(() => {
    function handleResize() {
      setWindowSize({
        width: window.innerWidth,
        height: window.innerHeight,
      });
    }

    window.addEventListener('resize', handleResize);
    handleResize();

    return () => window.removeEventListener('resize', handleResize);
  }, []);

  return windowSize;
}

// Usage
function ResponsiveComponent() {
  const { width, height } = useWindowSize();

  return (
    <div>
      Window size: {width} x {height}
    </div>
  );
}
```

---

## 9. Performance Optimization

### 9.1 React.memo

Mencegah re-render component jika props tidak berubah.

**Basic Usage:**
```jsx
const ExpensiveComponent = React.memo(({ data, onAction }) => {
  console.log('ExpensiveComponent rendered');

  return (
    <div>
      {data.map(item => (
        <div key={item.id}>{item.name}</div>
      ))}
      <button onClick={onAction}>Action</button>
    </div>
  );
});
```

**Custom Comparison:**
```jsx
const UserCard = React.memo(
  ({ user, onClick }) => {
    return (
      <div onClick={onClick}>
        <h2>{user.name}</h2>
        <p>{user.email}</p>
      </div>
    );
  },
  (prevProps, nextProps) => {
    // Return true if props are equal (skip re-render)
    return prevProps.user.id === nextProps.user.id;
  }
);
```

### 9.2 Code Splitting & Lazy Loading

**React.lazy & Suspense:**
```jsx
import { lazy, Suspense } from 'react';

const HeavyComponent = lazy(() => import('./HeavyComponent'));
const Dashboard = lazy(() => import('./Dashboard'));

function App() {
  return (
    <div>
      <Suspense fallback={<div>Loading...</div>}>
        <HeavyComponent />
      </Suspense>
    </div>
  );
}
```

**Route-based Code Splitting:**
```jsx
const Home = lazy(() => import('./pages/Home'));
const About = lazy(() => import('./pages/About'));
const Profile = lazy(() => import('./pages/Profile'));

function App() {
  return (
    <Router>
      <Suspense fallback={<LoadingSpinner />}>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="/profile" element={<Profile />} />
        </Routes>
      </Suspense>
    </Router>
  );
}
```

### 9.3 Virtualization

Render hanya visible items dalam large list.

**Concept (tanpa library):**
```jsx
function VirtualList({ items, itemHeight, containerHeight }) {
  const [scrollTop, setScrollTop] = useState(0);

  const startIndex = Math.floor(scrollTop / itemHeight);
  const endIndex = Math.ceil((scrollTop + containerHeight) / itemHeight);

  const visibleItems = items.slice(startIndex, endIndex);

  return (
    <div 
      style={{ height: containerHeight, overflow: 'auto' }}
      onScroll={(e) => setScrollTop(e.target.scrollTop)}
    >
      <div style={{ height: items.length * itemHeight }}>
        <div style={{ transform: `translateY(${startIndex * itemHeight}px)` }}>
          {visibleItems.map((item, index) => (
            <div key={startIndex + index} style={{ height: itemHeight }}>
              {item}
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
```

### 9.4 Optimization Patterns

**Avoid Inline Functions:**
```jsx
// Bad
function Parent() {
  return <Child onClick={() => console.log('clicked')} />;
}

// Good
function Parent() {
  const handleClick = useCallback(() => {
    console.log('clicked');
  }, []);

  return <Child onClick={handleClick} />;
}
```

**Avoid Inline Objects:**
```jsx
// Bad
function Parent() {
  return <Child style={{ color: 'red', fontSize: 14 }} />;
}

// Good
const style = { color: 'red', fontSize: 14 };

function Parent() {
  return <Child style={style} />;
}

// Or with useMemo for dynamic values
function Parent({ color }) {
  const style = useMemo(() => ({ 
    color, 
    fontSize: 14 
  }), [color]);

  return <Child style={style} />;
}
```

**Key Optimization:**
```jsx
// Bad - using index as key when list can change
{items.map((item, index) => (
  <div key={index}>{item.name}</div>
))}

// Good - using stable unique id
{items.map(item => (
  <div key={item.id}>{item.name}</div>
))}
```

---

## 10. Refs & DOM Manipulation

### 10.1 useRef for DOM

**Focus Management:**
```jsx
function SearchBar() {
  const inputRef = useRef(null);

  useEffect(() => {
    inputRef.current.focus();
  }, []);

  return <input ref={inputRef} placeholder="Search..." />;
}
```

**Scroll Management:**
```jsx
function ScrollToTop() {
  const topRef = useRef(null);

  const scrollToTop = () => {
    topRef.current.scrollIntoView({ behavior: 'smooth' });
  };

  return (
    <div>
      <div ref={topRef}>Top of page</div>
      {/* Long content */}
      <button onClick={scrollToTop}>Scroll to Top</button>
    </div>
  );
}
```

**Measuring Elements:**
```jsx
function MeasuredComponent() {
  const divRef = useRef(null);
  const [dimensions, setDimensions] = useState({ width: 0, height: 0 });

  useEffect(() => {
    if (divRef.current) {
      const { width, height } = divRef.current.getBoundingClientRect();
      setDimensions({ width, height });
    }
  }, []);

  return (
    <div ref={divRef}>
      Size: {dimensions.width} x {dimensions.height}
    </div>
  );
}
```

### 10.2 forwardRef

Passing refs melalui component.

**Basic forwardRef:**
```jsx
const CustomInput = forwardRef((props, ref) => {
  return <input ref={ref} {...props} />;
});

function Parent() {
  const inputRef = useRef(null);

  const focusInput = () => {
    inputRef.current.focus();
  };

  return (
    <div>
      <CustomInput ref={inputRef} />
      <button onClick={focusInput}>Focus</button>
    </div>
  );
}
```

**forwardRef with useImperativeHandle:**
```jsx
const FancyInput = forwardRef((props, ref) => {
  const inputRef = useRef(null);

  useImperativeHandle(ref, () => ({
    focus: () => {
      inputRef.current.focus();
    },
    clear: () => {
      inputRef.current.value = '';
    },
    getValue: () => {
      return inputRef.current.value;
    }
  }));

  return <input ref={inputRef} {...props} />;
});

// Usage
function Parent() {
  const fancyInputRef = useRef(null);

  return (
    <div>
      <FancyInput ref={fancyInputRef} />
      <button onClick={() => fancyInputRef.current.focus()}>Focus</button>
      <button onClick={() => fancyInputRef.current.clear()}>Clear</button>
      <button onClick={() => alert(fancyInputRef.current.getValue())}>
        Get Value
      </button>
    </div>
  );
}
```

---

## 11. Error Handling

### 11.1 Error Boundaries

Error boundaries catch JavaScript errors di child component tree.

**Basic Error Boundary:**
```jsx
class ErrorBoundary extends React.Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false, error: null };
  }

  static getDerivedStateFromError(error) {
    return { hasError: true, error };
  }

  componentDidCatch(error, errorInfo) {
    console.error('Error caught:', error, errorInfo);
    // Log to error reporting service
  }

  render() {
    if (this.state.hasError) {
      return (
        <div>
          <h1>Something went wrong</h1>
          <p>{this.state.error?.message}</p>
        </div>
      );
    }

    return this.props.children;
  }
}

// Usage
function App() {
  return (
    <ErrorBoundary>
      <MyComponent />
    </ErrorBoundary>
  );
}
```

**Error Boundary with Reset:**
```jsx
class ErrorBoundary extends React.Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false };
  }

  static getDerivedStateFromError(error) {
    return { hasError: true };
  }

  resetError = () => {
    this.setState({ hasError: false });
  };

  render() {
    if (this.state.hasError) {
      return (
        <div>
          <h1>Error occurred</h1>
          <button onClick={this.resetError}>Try Again</button>
        </div>
      );
    }

    return this.props.children;
  }
}
```

### 11.2 Async Error Handling

**Try-Catch in useEffect:**
```jsx
function DataFetcher({ url }) {
  const [data, setData] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(url);

        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }

        const json = await response.json();
        setData(json);
      } catch (err) {
        setError(err.message);
      }
    };

    fetchData();
  }, [url]);

  if (error) return <div>Error: {error}</div>;
  return <div>{JSON.stringify(data)}</div>;
}
```

---

## 12. Portals

Portal render children ke DOM node di luar parent component hierarchy.

**Basic Portal:**
```jsx
import { createPortal } from 'react-dom';

function Modal({ children, isOpen }) {
  if (!isOpen) return null;

  return createPortal(
    <div className="modal-overlay">
      <div className="modal">
        {children}
      </div>
    </div>,
    document.getElementById('modal-root')
  );
}

// HTML: <div id="modal-root"></div>

// Usage
function App() {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <div>
      <button onClick={() => setIsOpen(true)}>Open Modal</button>
      <Modal isOpen={isOpen}>
        <h1>Modal Content</h1>
        <button onClick={() => setIsOpen(false)}>Close</button>
      </Modal>
    </div>
  );
}
```

**Tooltip with Portal:**
```jsx
function Tooltip({ children, text }) {
  const [show, setShow] = useState(false);
  const [position, setPosition] = useState({ x: 0, y: 0 });
  const ref = useRef(null);

  const handleMouseEnter = () => {
    const rect = ref.current.getBoundingClientRect();
    setPosition({ x: rect.left, y: rect.top });
    setShow(true);
  };

  return (
    <>
      <span 
        ref={ref}
        onMouseEnter={handleMouseEnter}
        onMouseLeave={() => setShow(false)}
      >
        {children}
      </span>
      {show && createPortal(
        <div 
          style={{
            position: 'absolute',
            left: position.x,
            top: position.y - 30
          }}
          className="tooltip"
        >
          {text}
        </div>,
        document.body
      )}
    </>
  );
}
```

---

## 13. Patterns & Best Practices

### 13.1 Component Composition

**Container/Presentational Pattern:**
```jsx
// Container (logic)
function UserListContainer() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchUsers().then(data => {
      setUsers(data);
      setLoading(false);
    });
  }, []);

  const handleDelete = (id) => {
    setUsers(users.filter(u => u.id !== id));
  };

  return (
    <UserListPresentation 
      users={users} 
      loading={loading}
      onDelete={handleDelete}
    />
  );
}

// Presentational (UI)
function UserListPresentation({ users, loading, onDelete }) {
  if (loading) return <Spinner />;

  return (
    <ul>
      {users.map(user => (
        <li key={user.id}>
          {user.name}
          <button onClick={() => onDelete(user.id)}>Delete</button>
        </li>
      ))}
    </ul>
  );
}
```

**Compound Components:**
```jsx
const Tabs = ({ children, defaultTab }) => {
  const [activeTab, setActiveTab] = useState(defaultTab);

  return (
    <div className="tabs">
      {React.Children.map(children, child =>
        React.cloneElement(child, { activeTab, setActiveTab })
      )}
    </div>
  );
};

const TabList = ({ children, activeTab, setActiveTab }) => {
  return (
    <div className="tab-list">
      {React.Children.map(children, (child, index) =>
        React.cloneElement(child, {
          isActive: index === activeTab,
          onClick: () => setActiveTab(index)
        })
      )}
    </div>
  );
};

const Tab = ({ children, isActive, onClick }) => {
  return (
    <button 
      className={isActive ? 'active' : ''}
      onClick={onClick}
    >
      {children}
    </button>
  );
};

const TabPanel = ({ children, index, activeTab }) => {
  if (index !== activeTab) return null;
  return <div className="tab-panel">{children}</div>;
};

// Usage
function App() {
  return (
    <Tabs defaultTab={0}>
      <TabList>
        <Tab>Tab 1</Tab>
        <Tab>Tab 2</Tab>
        <Tab>Tab 3</Tab>
      </TabList>
      <TabPanel index={0}>Content 1</TabPanel>
      <TabPanel index={1}>Content 2</TabPanel>
      <TabPanel index={2}>Content 3</TabPanel>
    </Tabs>
  );
}
```

**Render Props:**
```jsx
function MouseTracker({ render }) {
  const [position, setPosition] = useState({ x: 0, y: 0 });

  const handleMouseMove = (e) => {
    setPosition({ x: e.clientX, y: e.clientY });
  };

  return (
    <div onMouseMove={handleMouseMove}>
      {render(position)}
    </div>
  );
}

// Usage
function App() {
  return (
    <MouseTracker 
      render={({ x, y }) => (
        <div>
          Mouse position: {x}, {y}
        </div>
      )}
    />
  );
}
```

**Higher-Order Components (HOC):**
```jsx
function withAuth(Component) {
  return function AuthenticatedComponent(props) {
    const { user, loading } = useAuth();

    if (loading) return <Spinner />;
    if (!user) return <Redirect to="/login" />;

    return <Component {...props} user={user} />;
  };
}

// Usage
const ProtectedDashboard = withAuth(Dashboard);
```

### 13.2 State Management Patterns

**Lifting State Up:**
```jsx
function Parent() {
  const [sharedState, setSharedState] = useState('');

  return (
    <div>
      <ChildA value={sharedState} onChange={setSharedState} />
      <ChildB value={sharedState} />
    </div>
  );
}

function ChildA({ value, onChange }) {
  return <input value={value} onChange={(e) => onChange(e.target.value)} />;
}

function ChildB({ value }) {
  return <div>Value: {value}</div>;
}
```

**State Colocation:**
```jsx
// Bad - state too high in tree
function App() {
  const [modalOpen, setModalOpen] = useState(false);
  const [formData, setFormData] = useState({});

  return (
    <div>
      <Header />
      <Content />
      <Modal isOpen={modalOpen} data={formData} />
    </div>
  );
}

// Good - state close to where it's used
function App() {
  return (
    <div>
      <Header />
      <Content />
      <ModalSection />
    </div>
  );
}

function ModalSection() {
  const [modalOpen, setModalOpen] = useState(false);
  const [formData, setFormData] = useState({});

  return <Modal isOpen={modalOpen} data={formData} />;
}
```

### 13.3 Code Organization

**Feature-based Structure:**
```
src/
├── features/
│   ├── auth/
│   │   ├── components/
│   │   ├── hooks/
│   │   ├── services/
│   │   └── index.js
│   ├── dashboard/
│   └── profile/
├── shared/
│   ├── components/
│   ├── hooks/
│   └── utils/
└── App.js
```

**Component File Structure:**
```jsx
// UserCard.jsx

// 1. Imports
import { useState, useEffect } from 'react';
import { formatDate } from '@/utils';
import './UserCard.css';

// 2. Types/Interfaces (if using TypeScript)
// interface UserCardProps { ... }

// 3. Constants
const DEFAULT_AVATAR = '/default-avatar.png';

// 4. Helper functions
function getInitials(name) {
  return name.split(' ').map(n => n[0]).join('');
}

// 5. Main component
export function UserCard({ user, onEdit, onDelete }) {
  const [isExpanded, setIsExpanded] = useState(false);

  return (
    <div className="user-card">
      {/* Component JSX */}
    </div>
  );
}

// 6. PropTypes (if not using TypeScript)
UserCard.propTypes = {
  user: PropTypes.object.isRequired,
  onEdit: PropTypes.func,
  onDelete: PropTypes.func
};

// 7. Default props
UserCard.defaultProps = {
  onEdit: () => {},
  onDelete: () => {}
};
```

---

## 14. Testing Basics

### 14.1 Component Testing Concepts

**Test Structure:**
```jsx
import { render, screen, fireEvent } from '@testing-library/react';
import { Counter } from './Counter';

describe('Counter', () => {
  test('renders initial count', () => {
    render(<Counter initialCount={0} />);
    expect(screen.getByText('Count: 0')).toBeInTheDocument();
  });

  test('increments count on button click', () => {
    render(<Counter initialCount={0} />);
    const button = screen.getByText('Increment');

    fireEvent.click(button);

    expect(screen.getByText('Count: 1')).toBeInTheDocument();
  });
});
```

**Testing Hooks:**
```jsx
import { renderHook, act } from '@testing-library/react';
import { useCounter } from './useCounter';

test('useCounter increments', () => {
  const { result } = renderHook(() => useCounter(0));

  act(() => {
    result.current.increment();
  });

  expect(result.current.count).toBe(1);
});
```

---

## 15. TypeScript dengan React

### 15.1 Basic Types

**Function Component with Props:**
```tsx
interface UserProps {
  name: string;
  age: number;
  email?: string;
  onAction: () => void;
}

function User({ name, age, email, onAction }: UserProps) {
  return (
    <div>
      <h1>{name}</h1>
      <p>Age: {age}</p>
      {email && <p>Email: {email}</p>}
      <button onClick={onAction}>Action</button>
    </div>
  );
}

// Or with React.FC
const User: React.FC<UserProps> = ({ name, age, email, onAction }) => {
  return <div>{/* ... */}</div>;
};
```

**useState with Types:**
```tsx
// Type inference
const [count, setCount] = useState(0); // number
const [name, setName] = useState(''); // string

// Explicit types
const [user, setUser] = useState<User | null>(null);

interface User {
  id: number;
  name: string;
  email: string;
}

const [users, setUsers] = useState<User[]>([]);
```

**Event Types:**
```tsx
function Form() {
  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    console.log(e.target.value);
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
  };

  const handleClick = (e: React.MouseEvent<HTMLButtonElement>) => {
    console.log('Clicked');
  };

  return (
    <form onSubmit={handleSubmit}>
      <input onChange={handleChange} />
      <button onClick={handleClick}>Submit</button>
    </form>
  );
}
```

**useRef Types:**
```tsx
function Component() {
  const inputRef = useRef<HTMLInputElement>(null);
  const timeoutRef = useRef<NodeJS.Timeout | null>(null);

  const focusInput = () => {
    inputRef.current?.focus();
  };

  return <input ref={inputRef} />;
}
```

**Custom Hook Types:**
```tsx
interface UseFetchResult<T> {
  data: T | null;
  loading: boolean;
  error: string | null;
}

function useFetch<T>(url: string): UseFetchResult<T> {
  const [data, setData] = useState<T | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    // fetch logic
  }, [url]);

  return { data, loading, error };
}

// Usage
interface User {
  id: number;
  name: string;
}

const { data, loading, error } = useFetch<User>('/api/user');
```

---

## 16. Build & Deployment

### 16.1 Create React App

**Setup:**
```bash
npx create-react-app my-app
cd my-app
npm start
```

**Build:**
```bash
npm run build
```

**Environment Variables:**
```
# .env
REACT_APP_API_URL=https://api.example.com
REACT_APP_API_KEY=your-key
```

```jsx
const apiUrl = process.env.REACT_APP_API_URL;
```

### 16.2 Vite

**Setup:**
```bash
npm create vite@latest my-app -- --template react
cd my-app
npm install
npm run dev
```

**Build:**
```bash
npm run build
npm run preview
```

**Environment Variables:**
```
# .env
VITE_API_URL=https://api.example.com
```

```jsx
const apiUrl = import.meta.env.VITE_API_URL;
```

### 16.3 Production Optimization

**Code Splitting:**
```jsx
const LazyComponent = lazy(() => import('./LazyComponent'));
```

**Environment-based Config:**
```jsx
const config = {
  apiUrl: process.env.NODE_ENV === 'production' 
    ? 'https://api.example.com'
    : 'http://localhost:3000'
};
```

---

## 17. React Frameworks & Libraries Ecosystem

### 17.1 Meta-Frameworks
- **Next.js** - Full-stack React framework dengan SSR, SSG, dan routing
- **Remix** - Full-stack framework fokus pada Web Fundamentals
- **Gatsby** - Static site generator berbasis React

### 17.2 Mobile & Desktop
- **React Native** - Framework untuk mobile apps (iOS & Android)
- **Expo** - Platform untuk React Native development
- **Electron** - Desktop apps dengan React

### 17.3 Routing
- **React Router** - Client-side routing library
- **TanStack Router** - Type-safe routing
- **Wouter** - Minimal routing solution

### 17.4 State Management
- **Redux Toolkit** - Opinionated Redux setup
- **Zustand** - Minimal state management
- **Jotai** - Atomic state management
- **Recoil** - State management dari Meta
- **MobX** - Observable state management
- **XState** - State machines

### 17.5 Data Fetching
- **TanStack Query** (React Query) - Server state management
- **SWR** - Data fetching dengan cache
- **Apollo Client** - GraphQL client
- **RTK Query** - Data fetching dari Redux Toolkit

### 17.6 Forms
- **React Hook Form** - Performant form library
- **Formik** - Form management
- **React Final Form** - Subscription-based forms

### 17.7 UI Component Libraries
- **Material-UI (MUI)** - Material Design components
- **Ant Design** - Enterprise UI components
- **Chakra UI** - Accessible component library
- **Shadcn/UI** - Customizable components dengan Radix UI
- **Radix UI** - Unstyled accessible components
- **Mantine** - Full-featured component library
- **Headless UI** - Unstyled components dari Tailwind
- **React Aria** - Accessible UI primitives dari Adobe

### 17.8 Styling
- **Styled Components** - CSS-in-JS
- **Emotion** - CSS-in-JS library
- **Tailwind CSS** - Utility-first CSS framework
- **CSS Modules** - Scoped CSS
- **Sass/SCSS** - CSS preprocessor

### 17.9 Animation
- **Framer Motion** - Production-ready animations
- **React Spring** - Spring-physics animations
- **GSAP** - Professional animation library
- **React Transition Group** - Transition components

### 17.10 Testing
- **Jest** - Testing framework
- **React Testing Library** - Component testing utilities
- **Vitest** - Vite-native test runner
- **Cypress** - E2E testing
- **Playwright** - E2E testing

### 17.11 Developer Tools
- **React DevTools** - Browser extension untuk debugging
- **Redux DevTools** - Redux state debugging
- **React Hook Form DevTools** - Form debugging
- **TanStack Query DevTools** - Query debugging

### 17.12 Build Tools
- **Vite** - Fast build tool
- **Create React App** - Official React bootstrapper
- **Webpack** - Module bundler
- **Turbopack** - Next-gen bundler dari Vercel
- **Parcel** - Zero-config bundler

### 17.13 Type Checking
- **TypeScript** - Static type checking
- **PropTypes** - Runtime type checking
- **Flow** - Static type checker dari Meta

### 17.14 Visualization & Charts
- **Recharts** - Composable chart library
- **Victory** - React chart components
- **Nivo** - Rich data visualization
- **Visx** - Low-level visualization primitives
- **React Chart.js** - Chart.js wrapper

### 17.15 Table & Data Grid
- **TanStack Table** (React Table) - Headless table library
- **AG Grid** - Enterprise data grid
- **MUI Data Grid** - Material-UI table

### 17.16 Drag & Drop
- **React DnD** - Drag and drop
- **dnd kit** - Modern drag and drop
- **React Beautiful DnD** - Beautiful DnD dari Atlassian

### 17.17 File Upload
- **React Dropzone** - File upload dengan drag & drop
- **Uppy** - File uploader

### 17.18 Internationalization (i18n)
- **React i18next** - Internationalization framework
- **React Intl** - i18n dari FormatJS

### 17.19 Date & Time
- **date-fns** - Modern date utility
- **Day.js** - Lightweight date library
- **React DatePicker** - Date picker component

### 17.20 Rich Text Editors
- **Draft.js** - Rich text framework
- **Slate** - Customizable rich text editor
- **Lexical** - Extensible text editor dari Meta
- **TipTap** - Headless editor framework
- **Quill** - Rich text editor

---

## 18. Performance Monitoring

### 18.1 React Profiler

**Using Profiler API:**
```jsx
import { Profiler } from 'react';

function onRenderCallback(
  id,
  phase,
  actualDuration,
  baseDuration,
  startTime,
  commitTime
) {
  console.log(`${id} (${phase}) took ${actualDuration}ms`);
}

function App() {
  return (
    <Profiler id="App" onRender={onRenderCallback}>
      <Content />
    </Profiler>
  );
}
```

---

## 19. Security Best Practices

**XSS Prevention:**
```jsx
// React automatically escapes content
function UserContent({ content }) {
  // Safe - React escapes by default
  return <div>{content}</div>;
}

// Dangerous - avoid dangerouslySetInnerHTML
function UnsafeContent({ html }) {
  return <div dangerouslySetInnerHTML={{ __html: html }} />;
}

// If you must use HTML, sanitize it first
import DOMPurify from 'dompurify';

function SafeHTML({ html }) {
  const clean = DOMPurify.sanitize(html);
  return <div dangerouslySetInnerHTML={{ __html: clean }} />;
}
```

**Authentication Patterns:**
```jsx
function ProtectedRoute({ children }) {
  const { user, loading } = useAuth();

  if (loading) return <Spinner />;
  if (!user) return <Navigate to="/login" />;

  return children;
}

// Usage
<Route path="/dashboard" element={
  <ProtectedRoute>
    <Dashboard />
  </ProtectedRoute>
} />
```

---

## 20. Advanced Patterns

### 20.1 Debouncing & Throttling

**Debounce:**
```jsx
function SearchInput() {
  const [query, setQuery] = useState('');
  const debouncedQuery = useDebounce(query, 500);

  useEffect(() => {
    if (debouncedQuery) {
      performSearch(debouncedQuery);
    }
  }, [debouncedQuery]);

  return (
    <input 
      value={query} 
      onChange={(e) => setQuery(e.target.value)} 
    />
  );
}
```

**Throttle:**
```jsx
function useThrottle(callback, delay) {
  const lastRun = useRef(Date.now());

  return useCallback((...args) => {
    if (Date.now() - lastRun.current >= delay) {
      callback(...args);
      lastRun.current = Date.now();
    }
  }, [callback, delay]);
}

function ScrollComponent() {
  const handleScroll = useThrottle(() => {
    console.log('Scrolled');
  }, 200);

  return <div onScroll={handleScroll}>{/* content */}</div>;
}
```

### 20.2 Infinite Scroll

**Basic Implementation:**
```jsx
function InfiniteList() {
  const [items, setItems] = useState([]);
  const [page, setPage] = useState(1);
  const [loading, setLoading] = useState(false);
  const observerTarget = useRef(null);

  useEffect(() => {
    const observer = new IntersectionObserver(
      entries => {
        if (entries[0].isIntersecting && !loading) {
          loadMore();
        }
      },
      { threshold: 1 }
    );

    if (observerTarget.current) {
      observer.observe(observerTarget.current);
    }

    return () => observer.disconnect();
  }, [loading]);

  const loadMore = async () => {
    setLoading(true);
    const newItems = await fetchItems(page);
    setItems(prev => [...prev, ...newItems]);
    setPage(prev => prev + 1);
    setLoading(false);
  };

  return (
    <div>
      {items.map(item => (
        <div key={item.id}>{item.name}</div>
      ))}
      <div ref={observerTarget} />
      {loading && <Spinner />}
    </div>
  );
}
```

### 20.3 Optimistic Updates

```jsx
function TodoList() {
  const [todos, setTodos] = useState([]);

  const toggleTodo = async (id) => {
    // Optimistic update
    setTodos(todos.map(todo =>
      todo.id === id ? { ...todo, completed: !todo.completed } : todo
    ));

    try {
      await api.toggleTodo(id);
    } catch (error) {
      // Revert on error
      setTodos(todos.map(todo =>
        todo.id === id ? { ...todo, completed: !todo.completed } : todo
      ));
      alert('Failed to update todo');
    }
  };

  return (
    <ul>
      {todos.map(todo => (
        <li key={todo.id}>
          <input
            type="checkbox"
            checked={todo.completed}
            onChange={() => toggleTodo(todo.id)}
          />
          {todo.text}
        </li>
      ))}
    </ul>
  );
}
```

---

## 21. Resources

### 21.1 Official Documentation
- React Docs: https://react.dev
- React GitHub: https://github.com/facebook/react

### 21.2 Learning Resources
- React Tutorial (Official)
- React Patterns
- React TypeScript Cheatsheet
- React Performance optimization guides

### 21.3 Community
- React Discord
- Reddit r/reactjs
- Stack Overflow react tag
- Dev.to react tag

---

**Version:** React 18+  
**Last Updated:** December 2025

---

# End of React Complete Reference Guide
