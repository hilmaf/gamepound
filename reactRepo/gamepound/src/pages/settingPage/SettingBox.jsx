import React from 'react';

const SettingBox = ({title}) => {
    return (<>
        <div>{title}</div>
        <div><input type="text" name='name'  /></div>
        <div>
            <button >저장</button>
        </div>
    </>);
};

export default SettingBox;