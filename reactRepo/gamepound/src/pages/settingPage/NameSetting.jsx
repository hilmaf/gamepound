
const NameSetting = () => {
    const baseURL = process.env.REACT_APP_API_URL;
    

    return (
        <>
            <div>이름</div>
            <div><input type="text"/></div>
            <div>
                <button>저장</button>
            </div>
        </>
    );
};

export default NameSetting;